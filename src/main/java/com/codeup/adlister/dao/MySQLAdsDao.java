package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;


import com.codeup.adlister.dao.Config;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

//    @Override
//    public List<Ad> all() {
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
//            return createAdsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all ads.", e);
//        }
//    }

//THIS IS THE UPDATED VERSION FROM ABOVE WITH A PREPARE STATEMENT INSTEAD

        @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM adlister_db.ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }



//    @Override
//    public Long insert(Ad ad) {
//        try {
//            Statement stmt = connection.createStatement();
//            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating a new ad.", e);
//        }
//    }


        @Override
    public Long insert(Ad ad) {
        try {
            //OLD CODE FROM PREVIOUS EXERCISE
//            Statement stmt
//            Statement stmt = connection.createStatement();
//            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);

            String sqlQuery = "INSERT INTO adlister_db.ads (user_id, title, description) VALUES ( ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, ad.getUserId());
            statement.setString(3, ad.getDescription());
            statement.setString(2, ad.getTitle());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            //we could this instead of the bottom if else, but the one we're using will show us if something went wrong

//            rs.next();
//            return rs.getLong(1);

            if(rs.next()){
                return rs.getLong(1);
            }else{
                return -1L;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(user_id, title, description) VALUES "
            + "(" + ad.getUserId() + ", "
            + "'" + ad.getTitle() +"', "
            + "'" + ad.getDescription() + "')";
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
