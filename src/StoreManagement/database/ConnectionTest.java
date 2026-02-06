package StoreManagement.database;

import java.sql.Connection;

public class ConnectionTest {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            System.out.println("Connection test passed! ");
            DatabaseConnection.closeConnection(connection);
        } else {
            System.out.println("Connection test failed! ");
        }
    }
}
