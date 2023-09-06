package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUserDao implements Users {

    private Connection connection = null;

    public MySQLUserDao(Config config) {
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

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM adlister_db.users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("error finding user by username" + username + ".", e);
        }
        return null;
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO adlister_db.users (username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getLong(1);
            }

        } catch (SQLException e){
            throw new RuntimeException("error adding user to database", e);
        }
        return -1L;
    }
}
