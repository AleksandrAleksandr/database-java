package database;
import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable{
    private String name;
    private Faculty faculty;
    private ArrayList<Student> students = new ArrayList<Student>();

    Group(String name_, Faculty fac)
    {
        name = name_;
        faculty = fac;
    }

    public void AddStudent(String first_name_, String second_name_, int birhday_)
    {
        students.add(new Student(first_name_, second_name_, birhday_, this.faculty,this));
    }

    public String GetName(){return name;}

    public ArrayList<Student> GetStudents(){ return students; }
}
