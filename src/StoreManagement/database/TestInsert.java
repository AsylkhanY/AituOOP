package StoreManagement.database;

import StoreManagement.model.Cashier;
import StoreManagement.model.Employee;

public class TestInsert {
    public static void main(String[] args){
        Employee employee = new Cashier(001, "Brat", 150000, 2024, 1);

        EmployeeDAO dao = new EmployeeDAO();
        dao.insertEmployee(employee);

    }

}
