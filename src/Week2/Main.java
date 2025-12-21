package Week2;

import java.sql.Array;

public class Main {
    public static void main(String[] args){
        Employee employee = new Employee(111, "Baha", Employee.JobPosition.Janitor, 10000);
        Product product = new Product(222,"Milk", true, 1000);
        Product product1 = new Product(333,"Bread", true, 300);
        Product product2 = new Product(444,"Eggs", true, 1200);
        Sale sale = new Sale(555, new Product[]{product, product1,product2}, "Asyl");

        employee.addBonus(10);
        System.out.println(employee);
        System.out.println(employee.getSalaryAfterTax(10));

        product.setPrice((int)product.getPriceAfterDiscount(10));
        System.out.println(product);

        System.out.println(sale);
    }
}
