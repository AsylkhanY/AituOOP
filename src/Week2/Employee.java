package Week2;

public class Employee {
    protected int id;
    protected String name;
    protected int salary;
    protected int experienceYears;

    public Employee(int id, String name, int salary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.experienceYears = experienceYears;
    }

    public void work() {
        System.out.println(name + " is performing general tasks.");
    }

    public String getRole() {
        return "General Staff";
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getSalary() { return salary; }
    public int getExperienceYears() { return experienceYears; }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name + " | Salary: " + salary;
    }
}