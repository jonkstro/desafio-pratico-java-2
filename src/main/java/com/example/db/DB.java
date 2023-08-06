package com.example.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    private static Connection conn = null;

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            // TODO: handle exception
            throw new DbException(e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            if (conn == null) {
                Properties props = loadProperties();
                String dburl = props.getProperty("dburl");
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                conn = DriverManager.getConnection(dburl, username, password);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

}
