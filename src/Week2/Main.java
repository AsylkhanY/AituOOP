package Week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Sale> sales = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        products.add(new Product(111, "Bread", true, 300));
        products.add(new Product(222, "Milk", true, 450));
        products.add(new Product(333, "Eggs", true, 900));

        employees.add(new Employee(101, "Baha", Employee.JobPosition.Janitor, 200000));
        employees.add(new Employee(102, "Adil", Employee.JobPosition.Cashier, 300000));
        employees.add(new Employee(103, "Beka", Employee.JobPosition.Manager, 450000));

        sales.add(new Sale(1, new Product[]{products.get(0), products.get(2)}, "Nurkhan"));

        boolean running = true;
        while (running) {
            displayMenu();
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
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
                        viewAllEmployees();
                        break;
                    case 5:
                        addSale();
                        break;
                    case 6:
                        viewAllSales();
                        break;
                    case 0:
                        System.out.println("\nGoodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice!");
                }
            } else {
                System.out.println("\nPlease enter a number.");
                scanner.nextLine();
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
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
        String name = scanner.nextLine();

        System.out.print("Enter price (KZT): ");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Is available? (true/false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine();

        Product item = new Product(id, name, available, price);
        products.add(item);
        System.out.println("\nProduct added successfully!");
    }

    private static void viewAllProducts() {
        System.out.println("\n--- ALL PRODUCTS ---");
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).toString());
        }
    }

    private static void addEmployee() {
        System.out.println("\n--- ADD EMPLOYEE ---");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter salary (KZT/month): ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Job Positions: 0=Manager, 1=Janitor, 2=Cashier, Other=None");
        System.out.print("Enter Job position ID: ");
        int jobPositionID = scanner.nextInt();
        scanner.nextLine();

        Employee.JobPosition jobPosition;
        switch (jobPositionID) {
            case 0: jobPosition = Employee.JobPosition.Manager; break;
            case 1: jobPosition = Employee.JobPosition.Janitor; break;
            case 2: jobPosition = Employee.JobPosition.Cashier; break;
            default: jobPosition = Employee.JobPosition.None;
        }

        Employee employee = new Employee(id, name, jobPosition, salary);
        employees.add(employee);
        System.out.println("\nEmployee added successfully!");
    }

    private static void viewAllEmployees() {
        System.out.println("\n--- ALL EMPLOYEES ---");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).toString());
        }
    }

    private static void addSale() {
        System.out.println("\n--- ADD SALE ---");

        if (products.isEmpty()) {
            System.out.println("Error: No products exist in the system. Add products first.");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Sale ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("How many items in this sale? ");
        int itemCount = scanner.nextInt();
        scanner.nextLine();

        Product[] saleProducts = new Product[itemCount];

        for (int i = 0; i < itemCount; i++) {
            viewAllProducts();
            System.out.print("Enter ID of product #" + (i + 1) + ": ");
            int prodId = scanner.nextInt();
            scanner.nextLine();

            Product selectedProduct = null;
            for (Product p : products) {
                if (p.getId() == prodId) {
                    selectedProduct = p;
                    break;
                }
            }

            if (selectedProduct != null) {
                saleProducts[i] = selectedProduct;
                System.out.println("Added " + selectedProduct.getName() + " to basket.");
            } else {
                System.out.println("Product not found! Adding Empty Product placeholder.");
                saleProducts[i] = new Product(); // Placeholder so code doesn't crash
            }
        }

        Sale sale = new Sale(id, saleProducts, customerName);
        sales.add(sale);
        System.out.println("\nSale completed successfully! Total Cost: " + sale.getCost());
    }

    private static void viewAllSales() {
        System.out.println("\n--- ALL SALES ---");
        if (sales.isEmpty()) {
            System.out.println("No sales history found.");
            return;
        }
        for (Sale sale : sales) {
            System.out.println(sale.toString());
            System.out.println("-------------------------");
        }
    }
}