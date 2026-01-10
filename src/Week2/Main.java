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

        employees.add(new Employee(101, "Baha", 200000, 2020));
        employees.add(new Manager(102, "Beka", 450000, 2018, 5));
        employees.add(new Cashier(103, "Adil", 300000, 2021, 1));

        sales.add(new Sale(1, new Product[]{products.get(0), products.get(2)}, "Nurkhan"));

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
                        addGeneralEmployee();
                        break;
                    case 4:
                        addManager();
                        break;
                    case 5:
                        addCashier();
                        break;
                    case 6:
                        viewAllEmployees();
                        break;
                    case 7:
                        demonstratePolymorphism();
                        break;
                    case 8:
                        viewCashiersOnly();
                        break;
                    case 9:
                        addSale();
                        break;
                    case 10:
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
        System.out.println("3. Add General Employee (Parent)");
        System.out.println("4. Add Manager (Child)");
        System.out.println("5. Add Cashier (Child)");
        System.out.println("6. View All Employees (Polymorphic)");
        System.out.println("7. Demonstrate Polymorphism");
        System.out.println("8. View Cashiers Only (Filter)");
        System.out.println("9. Add Sale");
        System.out.println("10. View All Sales");
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

    private static void addGeneralEmployee() {
        System.out.println("\n--- ADD GENERAL EMPLOYEE ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter year hired: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Employee emp = new Employee(id, name, salary, year);
        employees.add(emp);
        System.out.println("\nGeneral Employee added successfully!");
    }

    private static void addManager() {
        System.out.println("\n--- ADD MANAGER ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter year hired: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter team size: ");
        int teamSize = scanner.nextInt();
        scanner.nextLine();

        Manager manager = new Manager(id, name, salary, year, teamSize);
        employees.add(manager);
        System.out.println("\nManager added successfully!");
    }

    private static void addCashier() {
        System.out.println("\n--- ADD CASHIER ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter year hired: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter register number: ");
        int registerNum = scanner.nextInt();
        scanner.nextLine();

        Cashier cashier = new Cashier(id, name, salary, year, registerNum);
        employees.add(cashier);
        System.out.println("\nCashier added successfully!");
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

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        if (employees.isEmpty()) {
            System.out.println("No employees to demonstrate.");
            return;
        }
        for (Employee e : employees) {
            e.work();
        }
    }

    private static void viewCashiersOnly() {
        System.out.println("\n--- CASHIERS ONLY ---");
        boolean found = false;
        for (Employee e : employees) {
            if (e instanceof Cashier) {
                Cashier c = (Cashier) e;
                System.out.println(c.toString());
                c.scanItem();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cashiers found.");
        }
    }

    private static void addSale() {
        System.out.println("\n--- ADD SALE ---");

        if (products.isEmpty()) {
            System.out.println("Error: No products exist. Add products first.");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Sale ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("How many items? ");
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
                System.out.println("Added " + selectedProduct.getName());
            } else {
                System.out.println("Product not found! Adding Empty Product.");
                saleProducts[i] = new Product();
            }
        }

        Sale sale = new Sale(id, saleProducts, customerName);
        sales.add(sale);
        System.out.println("\nSale completed! Total: " + sale.getCost());
    }

    private static void viewAllSales() {
        System.out.println("\n--- ALL SALES ---");
        if (sales.isEmpty()) {
            System.out.println("No sales history.");
            return;
        }
        for (Sale sale : sales) {
            System.out.println(sale.toString());
            System.out.println("-------------------------");
        }
    }
}