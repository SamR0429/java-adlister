package com.codeup.adlister.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//package daos;
class Config {
        public String getUrl() {
            return "jdbc:mysql://localhost:3306/adlister_db?allowPublicKeyRetrieval=true&useSSL=false";
        }
        public String getUser() {
            return "root";
        }
        public String getPassword() {
            return "codeup";
        }
    }


