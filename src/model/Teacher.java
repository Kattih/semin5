package model;

public class Teacher extends User{

    private int teacherID;

    public Teacher(String firstName, String middleName, String lastName, int teacherID) {
        super(firstName, middleName, lastName);
        this.teacherID = teacherID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
