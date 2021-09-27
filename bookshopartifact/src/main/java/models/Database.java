package models;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private static Connection connection;
    
    public static void SetConnection() {
        if (connection == null) {
            connection = CreateConnection();
        }
    }
    
    private static Connection CreateConnection() {
        Connection c = null;
        URL databaseResource = Database.class.getClassLoader().getResource("BookShopAppDB.db");
        try {
            File databaseFile = Paths.get(databaseResource.toURI()).toFile();
            String databaseFilePath = "jdbc:sqlite:" + databaseFile.getAbsolutePath();
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(databaseFilePath);
        } catch (ClassNotFoundException | SQLException | URISyntaxException ex) {
            System.out.println(ex.getClass().getName() + " " + ex.getMessage());
            System.exit(0);
        }
        
        return c;
    }
    
    public static ResultSet ExecuteSQL(String sqlStatement) {
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery(sqlStatement);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }
}