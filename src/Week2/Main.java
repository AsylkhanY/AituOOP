package Week2;

public class Main {
    public static void main(String[] args){
        System.out.println("=== Grocery Store Management System ===");
        System.out.println();

        Employee emp1 = new Employee(111, "Baha", Employee.JobPosition.Janitor, 10000);
        Product prod1 = new Product(222, "Milk", true, 1000);
        Product prod2 = new Product(333, "Bread", true, 300);
        Product prod3 = new Product(444, "Eggs", true, 1200);

        Product prodEmpty = new Product();

        Sale sale1 = new Sale(555, new Product[]{prod1, prod2, prod3}, "Asyl");

        System.out.println("--- INITIAL STATE ---");
        System.out.println(emp1);
        System.out.println(prod1);
        System.out.println(prodEmpty);
        System.out.println(sale1);
        System.out.println();

        System.out.println("--- TESTING GETTERS ---");
        System.out.println("Employee Name: " + emp1.getName());
        System.out.println("Product Price: " + prod1.getPrice());
        System.out.println("Sale Customer: " + sale1.getCustomerName());
        System.out.println("Sale Bonus: " + sale1.getBonus());
        System.out.println();

        System.out.println("--- TESTING SETTERS ---");
        System.out.println("Promoting Baha to Manager...");
        emp1.setJobPosition(Employee.JobPosition.Manager);
        emp1.setSalary(15000);

        System.out.println("Updating Empty Product...");
        prodEmpty.setName("Almond Milk");
        prodEmpty.setPrice(1500);
        prodEmpty.setInStock(true);

        System.out.println("Updated Employee: " + emp1);
        System.out.println("Updated Product: " + prodEmpty);
        System.out.println();

        System.out.println("--- TESTING ADDITIONAL METHODS ---");
        System.out.println("Salary after 10% tax: " + emp1.getSalaryAfterTax(10));
        emp1.addBonus(5);
        System.out.println("Salary after 5% bonus: " + emp1.getSalary());

        System.out.println("Discount amount on " + prod1.getName() + ": " + prod1.getDiscountAmount(10));
        System.out.println("Price after 10% discount: " + prod1.getPriceAfterDiscount(10));

        System.out.println("Calculating sale cost: " + sale1.calculateCost());
        sale1.addBonus(10);
        System.out.println("Bonus points added: " + sale1.getBonus());
        System.out.println();

        System.out.println("--- FINAL SUMMARY ---");
        System.out.println(emp1);
        System.out.println(prod1);
        System.out.println(prodEmpty);
        System.out.println(sale1);

        System.out.println("\n=== Program Complete ===");
    }
}