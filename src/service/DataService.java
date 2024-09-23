package service;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private List<User> userList;

    public void create(String firstName, String middleName, String lastName, Type type){

        int id = getFreeID(type);
        if (Type.STUDENT == type){
            Student student = new Student(firstName,middleName,lastName, id);
            userList.add(student);
        }
        if (Type.TEACHER == type){
            Teacher teacher = new Teacher(firstName,middleName,lastName, id);
            userList.add(teacher);
        }
    }

    public User getUserById(Type type, int id){

        boolean itsStudent = Type.STUDENT ==  type;
        User currentUser = null;
        for (User user: userList) {
            if (user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherID() == id) {
                currentUser = user;
            }
            if (user instanceof Student && itsStudent && ((Student) user).getStudentID() == id){
                currentUser = user;
            }
        }
        return currentUser;
    }

    public List<User> getAllUsers(){
        return userList;
    }

    public List<User> getAllStudent(){
        List<User> students = new ArrayList<>();
        for(User user: userList){
            if (user instanceof Student){
                students.add(user);
            }
        }
        return students;
    }

    private int getFreeID(Type type){
        boolean itsStudent = Type.STUDENT ==  type;
        int lastId = 1;
        for (User user: userList) {
            if (user instanceof Teacher && !itsStudent) {
                lastId = ((Teacher) user).getTeacherID() + 1;
            }
            if (user instanceof Student && itsStudent){
                lastId = ((Student) user).getStudentID() + 1;
            }
        }
        return lastId;
    }
}
