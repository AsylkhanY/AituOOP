package Week2;

public class Cashier extends Employee {
    private int registerNumber;

    public Cashier(int id, String name, int salary, int experienceYears, int registerNumber) {
        super(id, name, salary, experienceYears);
        this.registerNumber = registerNumber;
    }

    @Override
    public void work() {
        System.out.println("Cashier " + name + " is scanning items at register #" + registerNumber);
    }

    @Override
    public String getRole() {
        return "Cashier";
    }

    public void processPayment() {
        System.out.println("Cashier " + name + " processed a payment.");
    }

    public void restockBags() {
        System.out.println("Cashier " + name + " is restocking bags.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Register: #" + registerNumber;
    }
}