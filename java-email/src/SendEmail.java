import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;

public class SendEmail {
    public static void main(String[] args) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("poczta.interia.pl");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("jan.bartosiewicz1", "Barcelona2003."));
        email.setSSLOnConnect(true);
        email.setFrom("jan.bartosiewicz1@interia.pl");
        email.setSubject("Witam");
        email.setMsg("Oto mail z wybraną ofertą");
        email.addTo("jan.bartosiewicz1@interia.pl");
        System.out.println("Rozpoczęto wysyłanie wiadomości email ");
        email.send();
        System.out.println("Wiadomość wysłana");
    }
}
