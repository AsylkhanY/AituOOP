package Week2;

public class Manager extends Employee {
    private int teamSize;

    public Manager(int id, String name, int salary, int yearHired, int teamSize) {
        super(id, name, salary, yearHired);
        setTeamSize(teamSize);
    }

    public void setTeamSize(int teamSize) {
        if(teamSize >= 0) {
            this.teamSize = teamSize;
        } else {
            this.teamSize = 0;
        }
    }
    public int getTeamSize() { return teamSize; }

    @Override
    public void work() {
        System.out.println("Manager " + name + " is supervising " + teamSize + " employees.");
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    public void holdMeeting() {
        System.out.println("Manager " + name + " is holding a team meeting.");
    }

    public void approveBudget() {
        System.out.println("Manager " + name + " is approving the budget.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Team Size: " + teamSize;
    }
}