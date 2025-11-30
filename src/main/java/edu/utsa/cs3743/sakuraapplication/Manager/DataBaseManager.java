package edu.utsa.cs3743.sakuraapplication.Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/lab3";
    private static final String USER = "root";
    private static final String Password = "Lopez9202%";


    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, Password);
        }catch (SQLException e){
            System.out.println("Error connecting to database" + e.getMessage());
            return null;
        }
    }
}
