import java.util.Optional;
import java.util.Scanner;

class ContactApp {
    public static void main(String[] args) {
        ContactReader.readFile("contacts")
                .ifPresentOrElse(ContactApp::findByEmail,ContactApp::print);

    }

    private static void findByEmail(ContactManager contactManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj adres email do wyszukania kontaktu:");
        String email = scanner.nextLine();
         contactManager.findByEmail(email)
                         .ifPresentOrElse(ContactApp::showShortInfo,ContactApp::contactNotFoundMessage );

    }

    private static void showShortInfo(Contact contactByEmail) {
        System.out.println("Kontakt o wskazanym adresie email:");
        System.out.println(contactByEmail.getShortInfo());
    }

    private static void print(){
        System.out.println("Brak pliku");
    }

    private static void contactNotFoundMessage(){
        System.out.println("Brak kontaktu");
    }

}