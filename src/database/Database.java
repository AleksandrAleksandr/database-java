package database;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable{

    private ArrayList<Faculty> faculties = new ArrayList<>();

    public void AddFaculty(String name)
    {
        faculties.add(new Faculty(name));
        System.out.println("Faculty successfully added");
    }

    public void AddGroup(String name, String faculty) throws NotFoundEx
    {
        for (Faculty fac : faculties ){
            if (fac.GetName().equals(faculty)){
                fac.AddGroup(name);
                System.out.println("Group successfully added");
                return;
            }
        }
        throw new NotFoundEx("No this faculty");
    }

    public void AddStudent(String name, String sec_name, int birthday, String group, String faculty) throws NotFoundEx
    {
        for (Faculty fac : faculties){
            if (fac.GetName().equals(faculty)) {
                for (Group gr : fac.GetGroups()) {
                    if (gr.GetName().equals(group)) {
                        gr.AddStudent(name, sec_name, birthday);

                        System.out.println("Student successfully added");
                        return;
                    }
                }
                throw new NotFoundEx("No this group");
            }

        }
        throw new NotFoundEx("No this faculty");
    }

    public void DeleteStudent(String name, String sec_name, int birthday) throws NotFoundEx {
        for (Faculty fac : faculties){
            for (Group gr : fac.GetGroups()){
                for (Student st : gr.GetStudents()){
                    if (st.getName().equals(name) && st.getAge() == birthday){
                        gr.GetStudents().remove(st);
                        System.out.println(name + " " + sec_name + " " + birthday + " " + gr.GetName() + " is deleted successfully");
                        return;
                    }
                }
            }
        }
        throw new NotFoundEx("No "+ name +" "+ sec_name+" in base");
    }

    public void DeleteGroup(String group, String faculty) throws NotFoundEx {
        for (Faculty fac : faculties){
            if (fac.GetName().equals(faculty)){
                for (Group gr : fac.GetGroups()){
                    if (gr.GetName().equals(group)){
                        fac.GetGroups().remove(gr);
                        System.out.println(group + " is deleted successfully");
                        return;
                    }
                }
            }
        }
        throw new NotFoundEx("No "+ group +" in base");
    }

    public void DeleteFaculty(String faculty) throws NotFoundEx {
        for (Faculty fac : faculties){
            if (fac.GetName().equals(faculty)){
                faculties.remove(fac);
                System.out.println("Faculty " + faculty + " is deleted successfully");
                return;
            }
        }
        throw new NotFoundEx("No "+ faculty +" in base");
    }

    public void StudentsByGroup(String group) throws NotFoundEx{
        System.out.println("Students in " + group + ":");
        for (Faculty fac : faculties){
            for (Group gr : fac.GetGroups()){
                if (gr.GetName().equals(group)){
                    for (Student st : gr.GetStudents())
                        System.out.println(st.toString());
                    return;
                }
            }
        }
        throw new NotFoundEx("No this group");
    }

    public void StudentsByFaculty(String faculty) throws NotFoundEx{
        System.out.println("Students of " + faculty + ":");
        for (Faculty fac : faculties) {
            if (fac.GetName().equals(faculty)){
                for (Group gr : fac.GetGroups()){
                    for (Student st : gr.GetStudents()){
                        System.out.println(st.toString());
                    }
                }
                return;
            }
        }
        throw new NotFoundEx("No this faculty");
    }

    public void StudentsByAge(int age){
        System.out.println("Students by age " + age + ":");
        for (Faculty fac : faculties) {
            for (Group gr : fac.GetGroups()){
                for (Student st : gr.GetStudents()){
                    if (st.getAge() == age){
                        System.out.println(st.toString());
                    }
                }
            }
        }
    }

    public void printBase(){
        if (baseIsEmpty()) {
            System.out.println("База пустая");
            return;
        }
        for (Faculty fac : faculties) {
            System.out.println(fac.GetName());
            for (Group gr : fac.GetGroups()) {
                System.out.println(" " + gr.GetName());
                for (Student st : gr.GetStudents()) {
                    System.out.println("  "+st.toString());
                }
            }
        }

    }

    private boolean baseIsEmpty(){
        for (Faculty fac : faculties){
            for (Group group : fac.GetGroups()){
                if (group.GetStudents().size() != 0) return false;
            }
        }
        return true;
    }

    public void Serialization(String file){
        if (baseIsEmpty()){
            System.out.println("База пустая");
            return;
        }
        try{
            ObjectOutputStream baseOS = new ObjectOutputStream(new FileOutputStream(file));
            baseOS.writeObject(this);
            System.out.println("Serialization success");

        }
        catch (Exception ex){
            System.out.println("[serialization ex] " + ex);
        }
    }

    public void Deserialization(String file) {
        try{
            ObjectInputStream baseIS = new ObjectInputStream(new FileInputStream(file));
            Database base2 = (Database) baseIS.readObject();
            System.out.println("Deserialization success, считанная база:\n");
            base2.printBase();
        }
        catch (FileNotFoundException ex){
            System.out.println(ex);

        }
        catch (Exception ex){
            System.out.println("[deserialization ex] " + ex);
        }
    }

}


