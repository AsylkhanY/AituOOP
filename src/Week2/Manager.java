package Week2;

public class Manager extends Employee {
    private int teamSize;

    public Manager(int id, String name, int salary, int experienceYears, int teamSize) {
        super(id, name, salary, experienceYears);
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        System.out.println("Manager " + name + " is supervising " + teamSize + " employees.");
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    public void conductMeeting() {
        System.out.println("Manager " + name + " is conducting a team meeting.");
    }

    public void approveBudget() {
        System.out.println("Manager " + name + " approved the weekly budget.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Team Size: " + teamSize;
    }
}