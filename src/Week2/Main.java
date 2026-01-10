package Week2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Sale> sales = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        products.add(new Product(111,"Bread", true, 300));
        products.add(new Product(222,"Milk", true, 450));
        products.add(new Product(333,"Eggs", true, 900));

        employees.add(new Employee(111,"Baha", Employee.JobPosition.Janitor, 200000));
        employees.add(new Employee(222,"Adil", Employee.JobPosition.Cashier, 300000));
        employees.add(new Employee(333,"Beka", Employee.JobPosition.Manager, 450000));

        sales.add(new Sale(1, new Product[]{products.get(0), products.get(2)}, "Nurkhan"));

        boolean running = true;
        while(running){
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    addEmployee();
                    break;
                case 4:
                    //viewAllEmplyees();
                    break;
                case 5:
                    //addSale();
                    break;
                case 6:
                    //viewAllSales();
                    break;
                case 0:
                    System.out.println("\nGoodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }
            if(running){
                System.out.println("\nPress enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println(" GROCERY STORE MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Add Employee");
        System.out.println("4. View All Employees");
        System.out.println("5. Add Sale");
        System.out.println("6. View All Sales");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static void addProduct() {
        System.out.println("\n--- ADD PRODUCT ---");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine(); // Read string
        System.out.print("Enter price (KZT): ");
        int price = scanner.nextInt(); // Read double
        scanner.nextLine(); // Consume newline
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Is available? (true/false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline
        Product item = new Product(id,name,available,price);
        products.add(item);
        System.out.println("\n Product added successfully!");
    }

    private static void viewAllProducts() {
        System.out.println("\n========================================");
        System.out.println(" ALL Products");
        System.out.println("========================================");
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Total products: " + products.size());
        System.out.println();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i); // Get item at index i
            System.out.println((i + 1) + ". " + product.getId() +
                    " - " + product.getPrice());
            System.out.println(" Name: " + product.getName());
            System.out.println(" Available: " +
                    (product.isInStock() ? " Yes" : " No"));
            System.out.println();
        }
    }

    private static void addEmployee() {
        System.out.println("\n--- ADD Employee ---");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine(); // Read string
        System.out.print("Enter salary (KZT/month): ");
        int salary = scanner.nextInt(); // Read double
        scanner.nextLine(); // Consume newline
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Job position?: ");
        int jobPositionID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (jobPositionID){
            case 0:

                break;
        }
        //Product item = new Product(id,name,available,price);
        //products.add(item);
        System.out.println("\n Product added successfully!");
    }
}