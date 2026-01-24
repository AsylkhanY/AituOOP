package StoreManagement.model;

public abstract class Employee {
    protected int id;
    protected String name;
    protected int salary;
    protected int yearHired;

    public Employee(int id, String name, int salary, int yearHired){
        setId(id);
        setName(name);
        setSalary(salary);
        setYearHired(yearHired);
    }

    public void setId(int id){this.id = id;}
    public int getId(){return id;}

    public void setName(String name){
        if(name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning! Name cannot be empty.");
            this.name = "Unknown";
        }
    }
    public String getName(){return name;}

    public void setSalary(int salary){
        if(salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Warning! Salary cannot be negative.");
            this.salary = 0;
        }
    }
    public int getSalary(){return salary;}

    public void setYearHired(int yearHired) {
        if(yearHired > 1900 && yearHired <= 2026) {
            this.yearHired = yearHired;
        } else {
            System.out.println("Warning! Invalid year.");
            this.yearHired = 2026;
        }
    }
    public int getYearHired() { return yearHired; }

    public abstract void work();

    public abstract String getRole();

    public boolean isLongTermEmployee() {
        return (2026 - yearHired) > 5;
    }

    @Override
    public String toString(){
        return "[" + getRole() + "] ID:" + id + " | Name:" + name + " | Salary:" + salary;
    }
}