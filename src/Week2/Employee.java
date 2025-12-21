package Week2;

public class Employee {
    private int id;
    private String name;
    private JobPosition jobPosition;
    private int salary;

    public Employee(int id, String name, JobPosition jobPosition, int salary){
        this.id = id;
        this.name = name;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public void setId(int id){this.id = id;}

    public int getId(){return id;}

    public void setName(String name){this.name = name;}

    public String getName(){return name;}

    public void setJobPosition(JobPosition jobPosition){this.jobPosition = jobPosition;}

    public JobPosition getJobPosition(){return jobPosition;}

    public void setSalary(int salary){this.salary = salary;}

    public int getSalary(){return salary;}

    public float getSalaryAfterTax(int taxPercent){
        return salary * (1 - (taxPercent)/100f);
    }

    public void addBonus(int bonusPercent) {
        salary += salary * bonusPercent / 100;
    }

    public enum JobPosition{
        Janitor,
        Cashier,
        Manager,
        Security
    }

    @Override
    public String toString(){
        return "ID:" + id + " Name:" + name + " Position:" + jobPosition.toString();
    }
}
