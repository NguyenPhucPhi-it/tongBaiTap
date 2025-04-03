package model;

public class Learn {
    private int learnID;
    private int studentID;
    private int classID;

    // Constructor
    public Learn(int learnID, int studentID, int classID) {
        this.learnID = learnID;
        this.studentID = studentID;
        this.classID = classID;
    }

    // Getters and Setters
    public int getLearnID() {
        return learnID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getClassID() {
        return classID;
    }
}
