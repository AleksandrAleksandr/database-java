package database;
import java.io.Serializable;

public class Student implements Serializable{
    private String first_name;
    private String second_name;
    private int birthday;
    private Faculty faculty;
    private Group group;
    private int id;
    private static int nextId = 0;

    Student(String first_name1, String second_name1, int birthday1, Faculty fac, Group gr)
    {
     first_name = first_name1;
     second_name = second_name1;
     birthday = birthday1;
     faculty = fac;
     group = gr;
     id = nextId;
     nextId++;
    }

    public String toString(){
        return first_name + " " + second_name + " "+ birthday + " , id: "+ id + ", faculty: " + faculty.GetName() + ", group: " + group.GetName();
    }

    public String getName(){ return first_name; }
    public int getAge(){ return birthday; }
}
