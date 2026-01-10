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

        employees.add(new Employee(101, "Baha", 200000, 2));
        employees.add(new Cashier(102, "Adil", 300000, 4, 5));
        employees.add(new Manager(103, "Beka", 450000, 8, 10));

        boolean running = true;
        while (running) {
            displayMenu();
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        viewAllProducts();
                        break;
                    case 3:
                        addEmployeeMenu();
                        break;
                    case 4:
                        viewAllEmployees();
                        break;
                    case 5:
                        demonstratePolymorphism();
                        break;
                    case 6:
                        viewManagersOnly();
                        break;
                    case 7:
                        addSale();
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
        System.out.println("3. Add Employee (Parent/Child)");
        System.out.println("4. View All Employees (Polymorphic)");
        System.out.println("5. Demonstrate Polymorphism");
        System.out.println("6. View Managers Only (Filter)");
        System.out.println("7. Add Sale");
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

    private static void addEmployeeMenu() {
        System.out.println("\n--- ADD EMPLOYEE ---");
        System.out.println("1. Add General Employee");
        System.out.println("2. Add Cashier");
        System.out.println("3. Add Manager");
        System.out.print("Select type: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Experience (Years): ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        if (type == 1) {
            employees.add(new Employee(id, name, salary, exp));
            System.out.println("Employee added.");
        } else if (type == 2) {
            System.out.print("Enter Register Number: ");
            int reg = scanner.nextInt();
            scanner.nextLine();
            employees.add(new Cashier(id, name, salary, exp, reg));
            System.out.println("Cashier added.");
        } else if (type == 3) {
            System.out.print("Enter Team Size: ");
            int team = scanner.nextInt();
            scanner.nextLine();
            employees.add(new Manager(id, name, salary, exp, team));
            System.out.println("Manager added.");
        } else {
            System.out.println("Invalid type selected.");
        }
    }

    private static void viewAllEmployees() {
        System.out.println("\n--- ALL EMPLOYEES ---");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        if (employees.isEmpty()) {
            System.out.println("No employees.");
            return;
        }
        for (Employee e : employees) {
            e.work();
        }
    }

    private static void viewManagersOnly() {
        System.out.println("\n--- MANAGERS ONLY ---");
        boolean found = false;
        for (Employee e : employees) {
            if (e instanceof Manager) {
                Manager m = (Manager) e;
                System.out.println(m.toString());
                m.conductMeeting();
                found = true;
            }
        }
        if (!found) System.out.println("No managers found.");
    }

    private static void addSale() {
        System.out.println("\n--- ADD SALE ---");
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Sale ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Item count: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Product[] items = new Product[count];
        for(int i=0; i<count; i++){
            System.out.print("Enter Product ID for item " + (i+1) + ": ");
            int pid = scanner.nextInt();
            scanner.nextLine();
            for(Product p : products){
                if(p.getId() == pid) items[i] = p;
            }
            if(items[i] == null) items[i] = new Product();
        }
        sales.add(new Sale(id, items, customerName));
        System.out.println("Sale added.");
    }
}