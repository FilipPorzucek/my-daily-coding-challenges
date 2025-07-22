package com.emailApp;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class App
{
    public static void main( String[] args ) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("poczta.interia.pl");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("jan.bartosiewicz1", "Barcelona2003.aaaa"));
        email.setSSLOnConnect(true);
        email.setFrom("jan.bartosiewicz1@interia.pl");
        email.setSubject("Witamy");
        email.setMsg("kochamcie");
        email.addTo("a.zielinska8888@gmail.com");
        System.out.println("Rozpoczęto wysyłanie wiadomości email ");
        email.send();
        System.out.println("Wiadomość wysłana");
    }
}
