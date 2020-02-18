package database;
import java.io.Serializable;
import java.util.ArrayList;

public class Faculty implements Serializable{

    private String name;
    private int id;
    private ArrayList<Group> groups = new ArrayList<Group>();
    private ArrayList<Student> students = new ArrayList<>();

    Faculty(String name_){
        name = name_;
    }

    public void AddGroup(String name_)
    {
        groups.add(new Group(name_, this));
    }

    public String GetName(){return name;}
    public ArrayList<Group> GetGroups(){return groups;}
    public ArrayList<Student> GetStudents(){return students;}

}
