package age;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class FIO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(format.format(dateNow));
        Date now = null;
        Date birth = null;

        while(true) {
            System.out.println("Введите имя:");
            String name = in.nextLine();
            System.out.println("Ввелите фамилию:");
            String sec_name = in.nextLine();
            System.out.println("Введите дату рождения:");
            String birthday = in.nextLine();
            try {
                now = format.parse(format.format(dateNow));
                birth = format.parse(birthday);
            }
            catch (ParseException ex){
                System.out.println("[ex]");
            }
            //System.out.println(now + " " + birth);

            //if (name + " " + sec_name + " " +(now.getTime()-birth.getTime())/(24*60*60*1000)/365 % 10 ==)
            System.out.println(name + " " + sec_name + " " +(now.getTime()-birth.getTime())/(24*60*60*1000)/365 + " years");
            //System.out.println(name + " " + sec_name + " 50 years");

        }
    }
}
