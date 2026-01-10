package Week2;

public class Employee {
    private int id;
    private String name;
    private JobPosition jobPosition;
    private int salary;

    public Employee(int id, String name, JobPosition jobPosition, int salary){
        setId(id);
        setName(name);
        setJobPosition(jobPosition);
        setSalary(salary);
    }

    public void setId(int id){this.id = id;}
    public int getId(){return id;}

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setJobPosition(JobPosition jobPosition){
        if(jobPosition != JobPosition.None) {
            this.jobPosition = jobPosition;
        } else {
            System.out.println("Warning! Cannot set job position as NONE");
            this.jobPosition = JobPosition.Janitor; // Default backup
        }
    }
    public JobPosition getJobPosition(){return jobPosition;}

    public void setSalary(int salary){
        if(salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Warning! Salary cannot be negative.");
            this.salary = 0;
        }
    }
    public int getSalary(){return salary;}

    public enum JobPosition{
        Janitor, Cashier, Manager, Security, None
    }

    @Override
    public String toString(){
        return "ID: " + id + " | Name: " + name + " | Position: " + jobPosition + " | Salary: " + salary;
    }
}