package com.fullstackdemo_31082024.fullstackdemo_31082024.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connection;

    public static Connection getConnection() {


        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank",
                        "root", "12345");
            } else {
                System.out.println("Returning Existing Connection");
            }
        } catch (Exception exception) {
            System.out.println("Exception Occured In GetConnection " + exception);
        }
        return connection;
    }
}
