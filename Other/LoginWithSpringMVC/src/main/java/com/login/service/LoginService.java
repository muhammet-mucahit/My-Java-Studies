package com.login.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    static public boolean check(String username, String password) {

        String url = "jdbc:mysql://localhost:3307/login";
        String db_username = "admin";
        String db_password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, db_username, db_password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE uname = ? and pass = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
