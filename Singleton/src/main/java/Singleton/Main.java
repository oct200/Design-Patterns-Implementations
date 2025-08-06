package Singleton;

import java.sql.Connection;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Connection conn1 = DatabaseConnection.getInstance().getConnection();
        Connection conn2 = DatabaseConnection.getInstance().getConnection();
    }
}