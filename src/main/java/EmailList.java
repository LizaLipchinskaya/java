import java.util.TreeSet;

public class EmailList {
    private static TreeSet<String> emailList = new TreeSet<>();

    public EmailList() {
        emailList = new TreeSet<>();
    }

    public void add(String email) {
        if (emailList.contains(email)) {
            return;
        }

        emailList.add(email);
    }

    public TreeSet<String> getSortedEmails() {
        return emailList;
    }

}
