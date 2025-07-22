import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class EmailManager {
    public static void main(String[] args) {
        List<Email> emailList = createEmailList();

        //tylko wysłane emaile
        System.out.println("tylko wyslane maile");
        List<Email> sentEmails = filterEmails(emailList,email -> email.isSent());
        System.out.println(sentEmails);
        //filtrowanie maili, w których nadawca lub odbiorca ma wskazany adres email



        List<Email> bartEmails = filterEmails(emailList, (Email email)->email.isSenderOrRecipent("bart@example.com"));
        System.out.println("Maile przefiltrowane na podstawie nadawcy lub odbiorcy");
        System.out.println(bartEmails);
    }

    private static<T> List<T> filterEmails(List<T> list, Predicate<T> predicate){
        List result=new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t))
                result.add(t);
        }
        return result;
    }


    private static List<Email> createEmailList() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(
                "joe@example.com",
                "barbara@example.com",
                "Kup bułki",
                "Cześć!, Kup proszę bułki, gdy będziesz wracać z pracy.",
                false)
        );
        emails.add(new Email(
                "carl@example.com",
                "joe@example.com",
                "Nowa inwestycja",
                "Siema! Musimy omówić temat nowej inwestycji, pasuje Ci jutro?",
                true)
        );
        emails.add(new Email(
                "joe@example.com",
                "bart@example.com",
                "Wypad na miasto",
                "Cześć. Idziemy dzisiaj wieczorem z chłopakami na miasto. Dołączasz do nas?",
                true)
        );
        return emails;
    }
}