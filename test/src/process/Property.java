package process;

public class Property {
    private String name;
    private int increasedRunTime;
    private int maxRunTime;
    private String state;

    Property(String name, int increasedRunTime, int maxRunTime, String state) {
        this.name = name;
        this.increasedRunTime = increasedRunTime;
        this.maxRunTime = maxRunTime;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public int getIncreasedRunTime() {
        return increasedRunTime;
    }

    public int getMaxRunTime() {
        return maxRunTime;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return name + "(" + state + ")" + "," + " " + increasedRunTime + "/" + maxRunTime;
    }
}
