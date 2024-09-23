package model;

public class Student extends User{

    private int studentID;

    public Student(String firstName, String middleName, String lastName, int studentID) {
        super(firstName, middleName, lastName);
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                '}';
    }
}
