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

    public void setId(int id){
        if(id < 0){
            throw new IllegalArgumentException("Enter a positive integer!");
        }
        this.id = id;
    }
    public int getId(){return id;}

    public void setName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
    }
    public String getName(){return name;}

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }
    public int getSalary(){return salary;}

    public void setYearHired(int yearHired){
        if(yearHired < 1900 || yearHired > 2026){
            throw new IllegalArgumentException("Enter valid year!");
        }
        this.yearHired = yearHired;
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