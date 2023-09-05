import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.Config;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM adlister_db.ads");
            while (rs.next()) {
                Ad ad = new Ad(
                        rs.getLong("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
                ads.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        Long lastInsertedID = 0L;
        try {
            Statement statement = connection.createStatement();
            String insertQuery = String.format("INSERT INTO ads(user_id, title, description) VALUES('%d', '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());
            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            lastInsertedID = rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lastInsertedID;
    }


//    return ads;


    public static void main(String[] args) {

//this should work as a test run when you've done everything right
        MySQLAdsDao mySQLAdsDao = new MySQLAdsDao(new Config());
        System.out.println(mySQLAdsDao.all());




    }

}
