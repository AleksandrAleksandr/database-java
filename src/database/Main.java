package database;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args){
        /*FileOutputStream fos = new FileOutputStream("file.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student s1 = addStudent("Russel", "Westbrook", "10.07.1998");
        oos.writeObject(s1);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("file.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student s2 = (Student) ois.readObject();
        System.out.println(s2.getName());*/
        Database base = new Database();
        /*try {
            base.AddFaculty("Hogwarts");
            base.AddGroup("Alchemistry", "Hogwarts");
            base.AddGroup("Herbalism", "Hogwarts");
            base.AddStudent("Ron", "Uisley", 14, "Alchemistry", "Hogwarts");
            base.AddStudent("Harry", "Potter", 13, "Alchemistry", "Hogwarts");
            base.AddStudent("Drako", "Malfoy", 16, "Herbalism", "Hogwarts");
            //base.StudentsByAge(14);
            //base.DeleteStudent("Harry", "Potter", 13);
        }
        catch (Exception ex){
            System.out.println(ex);
        }


        try{
            ObjectOutputStream baseOS = new ObjectOutputStream(new FileOutputStream("base"));
            baseOS.writeObject(base);
            System.out.println("Serial success");
        }
        catch (IOException ex) {
            System.out.println("serialization ex - " + ex);
        }

        try{
            ObjectInputStream baseIS = new ObjectInputStream(new FileInputStream("base"));
            Database baseSerial = (Database) baseIS.readObject();
            //baseSerial.StudentsByGroup("Herbalism");
            System.out.println("Deserial success");
        }
        catch (Exception ex){
            System.out.println("deserialization ex - " + ex);
        }*/
        Scanner in = new Scanner(System.in);
        boolean finish = false;
        while(true){
            System.out.println("\nВведите команду:\n 1 - AddFaculty\n" +
                    " 2 - AddGroup\n" +
                    " 3 - AddStudent\n" +
                    " 4 - DeleteStudent\n" +
                    " 5 - DeleteGroup\n" +
                    " 6 - StudentsByGroup\n" +
                    " 7 - StudentsByFaculty\n" +
                    " 8 - printBase\n" +
                    " 9 - serialize\n" +
                    " 10 - deserialize\n" + " 11 - deserialize in current base\n" + " 0 - exit");
            String kommand = in.next();

            try {
                switch (kommand) {
                    case "1":
                        System.out.println("Введите название факультета");
                        String info = in.next();
                        base.AddFaculty(info);
                        break;
                    case "2":
                        System.out.println("Введите название группы");
                        String group = in.next();
                        System.out.println("Введите название факультета");
                        String fac = in.next();
                        base.AddGroup(group, fac);
                        break;
                    case "3":
                        System.out.println("Введите имя");
                        String name = in.next();
                        System.out.println("Введите фамилию");
                        String sec_name = in.next();
                        System.out.println("Введите возраст");
                        int age = in.nextInt();
                        System.out.println("Введите название факультета");
                        String st_fac = in.next();
                        System.out.println("Введите название группы");
                        String st_group = in.next();
                        base.AddStudent(name, sec_name, age, st_group, st_fac);
                        break;
                    case "4":
                        System.out.println("Введите имя");
                        String st_name = in.next();
                        System.out.println("Введите фамилию");
                        String st_sec_name = in.next();
                        System.out.println("Введите возраст");
                        int st_age = in.nextInt();
                        base.DeleteStudent(st_name, st_sec_name, st_age);
                        break;
                    case "5":
                        System.out.println("Введите название группы");
                        String gr = in.next();
                        System.out.println("Введите название факультета");
                        String fa = in.next();
                        base.DeleteGroup(gr, fa);
                        break;
                    case "6":
                        System.out.println("Введите название группы");
                        String group_name = in.next();
                        base.StudentsByGroup(group_name);
                        break;
                    case "7":
                        System.out.println("Введите название факультета");
                        String fac_name = in.next();
                        base.StudentsByFaculty(fac_name);
                        break;
                    case "8":
                        base.printBase();
                        break;
                    case "9":
                        System.out.println("Введите название файла куда копировать");
                        String file_name = in.next();
                        base.Serialization(file_name);
                        break;
                    case "10":
                        System.out.println("Введите название файла откуда считывать");
                        String file = in.next();
                        base.Deserialization(file);
                        break;
                    case "11":
                        ObjectInputStream baseIS = new ObjectInputStream(new FileInputStream("base"));
                        base = (Database) baseIS.readObject();
                        System.out.println("Deserialization success");
                        break;
                    case "0":
                        finish = true;
                        break;
                    default:
                        System.out.println("incorrect сommand");

                }
            }
            catch (Exception ex){
                System.out.println(ex);
            }

            if (finish){
                break;
            }

        }

    }
}
