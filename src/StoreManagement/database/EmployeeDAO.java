package StoreManagement.database;

import StoreManagement.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
    public void insertEmployee(Employee employee){
        String sql = "INSERT INTO employees (name, salary, year_hired) VALUES (?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getSalary());
            statement.setInt(3, employee.getYearHired());

            int rowsInserted = statement.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("Employee Inserted Successfully!");
            }
            statement.close();
        }
        catch (SQLException e){
            System.out.println("Insert Failed!");
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
