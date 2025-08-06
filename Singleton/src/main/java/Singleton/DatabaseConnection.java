package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    String connString = "jdbc:sqlite:D:/GithubRepos/mpp-proiect-java-oct200/Server/Moto.sqlite";
    private Connection connection;

    private DatabaseConnection() throws SQLException {
        connection = getNewConnection();
    }

    private Connection getNewConnection() throws SQLException{
        return DriverManager.getConnection(connString);
    }

    public static DatabaseConnection getInstance(){
        try {
            if (instance == null) {
                instance = new DatabaseConnection();
                System.out.println("Created new database connection");
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
