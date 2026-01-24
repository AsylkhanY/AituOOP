package StoreManagement.model;

public class Cashier extends Employee {
    private int registerNumber;

    public Cashier(int id, String name, int salary, int yearHired, int registerNumber) {
        super(id, name, salary, yearHired);
        setRegisterNumber(registerNumber);
    }

    public void setRegisterNumber(int registerNumber) {
        if(registerNumber > 0) {
            this.registerNumber = registerNumber;
        } else {
            this.registerNumber = 1;
        }
    }
    public int getRegisterNumber() { return registerNumber; }

    @Override
    public void work() {
        System.out.println("Cashier " + name + " is scanning items at register #" + registerNumber);
    }

    @Override
    public String getRole() {
        return "Cashier";
    }

    public void scanItem() {
        System.out.println("Cashier " + name + " is scanning a product.");
    }

    public void processRefund() {
        System.out.println("Cashier " + name + " is processing a refund.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Register: #" + registerNumber;
    }
}