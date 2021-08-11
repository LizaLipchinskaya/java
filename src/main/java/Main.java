import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    private static EmailList emailList = new EmailList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }
            
            String[] str = input.split("\\s");

            switch (str[0]) {
                case "ADD" :
                    str[1] = str[1].toLowerCase(Locale.ROOT);

                    if (str[1].endsWith(".ru")) {
                        emailList.add(str[1]);
                    } else {
                        System.out.println(WRONG_EMAIL_ANSWER);
                    }

                    break;

                case "LIST" :
                    TreeSet<String> output = emailList.getSortedEmails();

                    for (String email : output) {
                        System.out.println(email);
                    }

                    break;
            }
        }
    }
}
