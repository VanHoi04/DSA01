public class Student {
    private String id;
    private String name;
    private double marks;
    private String rank;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        assignRank();
    }

    public void assignRank() {
        if (marks < 5.0) {
            this.rank = "Fail";
        } else if (marks < 6.5) {
            this.rank = "Medium";
        } else if (marks < 7.5) {
            this.rank = "Good";
        } else if (marks < 9.0) {
            this.rank = "Very Good";
        } else {
            this.rank = "Excellent";
        }
    }

    public void update(String name, double marks) {
        this.name = name;
        this.marks = marks;
        assignRank();
    }

    @Override
    public String toString() {
        return id + ": " + name + ", " + marks + ", " + rank;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRank() {
        return rank;
    }
}
