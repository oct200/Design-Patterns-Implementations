package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() throws SQLException {
        connection = getNewConnection();
    }

    private Connection getNewConnection() throws SQLException{
        Properties p = DatabaseProperties.getInstance().getProp();
        String connString = p.getProperty("connString");
        return DriverManager.getConnection(connString);
    }

    public static DatabaseConnection getInstance(){
        try {
            if(instance == null) {
                synchronized (DatabaseConnection.class) {
                    if (instance == null) {
                        instance = new DatabaseConnection();
                        System.out.println("Created new database connection");
                    }
                }
            }
            System.out.println("Returning previous database connection");
            return instance;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
