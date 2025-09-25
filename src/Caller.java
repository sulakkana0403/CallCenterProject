// Caller.java
public class Caller {
    private int id;
    private String name;
    private String issue;

    public Caller(int id, String name, String issue) {
        this.id = id;
        this.name = name;
        this.issue = issue;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getIssue() { return issue; }

    @Override
    public String toString() {
        return id + ": " + name + " - " + issue;
    }
}