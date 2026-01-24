package StoreManagement.menu;

import StoreManagement.Sale;
import StoreManagement.exception.InvalidInputException;
import StoreManagement.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreMenu implements Menu {
    private ArrayList<Product> products;
    private ArrayList<Employee> employees;
    private ArrayList<Sale> sales;

    private static Scanner scanner = new Scanner(System.in);

    public StoreMenu() {
        this.products = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.sales = new ArrayList<>();
        try {
            products.add(new Product(111, "Bread", true, 300));
            products.add(new Product(222, "Milk", true, 450));
            products.add(new Product(333, "Eggs", true, 900));
            products.add(new Product(444, "Premium Steak", true, 5000));

            employees.add(new Manager(102, "Beka", 450000, 2018, 5));
            employees.add(new Cashier(103, "Adil", 300000, 2021, 1));

            sales.add(new Sale(1, new Product[]{products.get(0), products.get(2)}, "Nurkhan"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println(" GROCERY STORE MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Add Manager (Child)");
        System.out.println("4. Add Cashier (Child)");
        System.out.println("5. View All Employees (Polymorphic)");
        System.out.println("6. Demonstrate Polymorphism");
        System.out.println("7. View Cashiers Only (Filter)");
        System.out.println("8. Add Sale");
        System.out.println("9. View All Sales");
        System.out.println("10. Check Discounts & Promotions (Interface)"); // NEW OPTION
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
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
                            addManager();
                            break;
                        case 4:
                            addCashier();
                            break;
                        case 5:
                            viewAllEmployees();
                            break;
                        case 6:
                            demonstratePolymorphism();
                            break;
                        case 7:
                            viewCashiersOnly();
                            break;
                        case 8:
                            addSale();
                            break;
                        case 9:
                            viewAllSales();
                            break;
                        case 10:
                            checkDiscounts();
                            break;
                        case 0:
                            System.out.println("\nGoodbye!");
                            running = false;
                            break;
                        default:
                            System.out.println("\nInvalid choice!");
                    }
                }
                else {
                    System.out.println("\nPlease enter a number.");
                    scanner.nextLine();
                }

                if (running) {
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid number!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    private void checkDiscounts() {
        System.out.println("\n--- PRODUCT DISCOUNTS & PROMOTIONS ---");
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        System.out.print("Enter a test discount percentage (e.g. 10): ");
        double percent = 0;
        try {
            percent = scanner.nextDouble();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid number using default 0%.");
            scanner.nextLine();
        }

        System.out.println("\nApplying " + percent + "% discount to all items:");
        System.out.println("------------------------------------------------");

        for (Product p : products) {
            if (p instanceof Discountable) {
                System.out.println("Product: " + p.getName());
                System.out.println("Original Price: " + p.getPrice() + " KZT");
                System.out.println("Status: " + p.getPromotionDetails());
                System.out.println("Discounted Price: " + p.getDiscountedPrice(percent) + " KZT");
                System.out.println("------------------------------------------------");
            }
        }
    }

    private void addProduct() {
        try {
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
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewAllProducts() {
        System.out.println("\n--- ALL PRODUCTS ---");
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).toString());
        }
    }

    private void addManager() {
        try {
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
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void addCashier() {
        try {
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
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewAllEmployees() {
        System.out.println("\n--- ALL EMPLOYEES ---");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).toString());
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        if (employees.isEmpty()) {
            System.out.println("No employees to demonstrate.");
            return;
        }
        for (Employee e : employees) {
            e.work();
        }
    }

    private void viewCashiersOnly() {
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

    private void addSale() {
        try {
            System.out.println("\n--- ADD SALE ---");

            if (products.isEmpty()) {
                System.out.println("Error: No products exist. Add products first.");
                return;
            }

            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();

            if(customerName.length() < 2){
                throw new InvalidInputException("Name can not be less than 2 letters!");
            }

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
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewAllSales() {
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