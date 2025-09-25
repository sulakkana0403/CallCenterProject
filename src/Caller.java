public class Caller {
    int id;
    String name;
    String issue;

    public Caller(int id, String name, String issue) {
        this.id = id;
        this.name = name;
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Caller ID: " + id + ", Name: " + name + ", Issue: " + issue;
    }
}
