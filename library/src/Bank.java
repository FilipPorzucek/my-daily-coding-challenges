import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Bank {
    public static void main(String[] args) {

        person person1=new person();
        person1.firstName="Jan";
        person1.lastName="Kowalski";
        person1.pesel="1234567";

        bankAcount account1=new bankAcount();
        account1.owner=person1;
        account1.balance=10000;

        credit credit1=new credit();
       credit1.borrower=person1;
        credit1.cashBorrowed=5000;
        credit1.cashReturned=0;
        credit1.intersRate=0.10;
        credit1.termMonths=12;
        person1.personAdres.street="Nowa";
        person1.personAdres.City="Warszawa";
        person1.personAdres.numberOfHome=34;

        System.out.println("Osoba:");
        System.out.println(person1.firstName+" "+person1.lastName+" "+person1.pesel);
        System.out.println("posiada konto bankowe z kwota:"+account1.balance);
        System.out.println("Kredyt na kwote"+credit1.cashBorrowed);
        System.out.println("Jego adres to"+" "+person1.personAdres.City+person1.personAdres.street+" "+person1.personAdres.numberOfHome);

        person person2=new person();
        person2.firstName="Kasia";
        person2.lastName="Nowak";
        person2.pesel="634729374";
        bankAcount acount2=new bankAcount();
        acount2.owner=person2;
        acount2.balance=34000;
        credit credit2=new credit();
        credit2.cashBorrowed=9000;
        credit2.cashReturned=3200;
        credit2.intersRate=0.12;
        credit2.termMonths=24;
        person2.personAdres.City="Jarocin";
        person2.personAdres.street="Jagiely";
        person2.personAdres.numberOfHome=56;
        System.out.println("Osoba:");
        System.out.println(person2.firstName+" "+person2.lastName+" "+person2.pesel);
        System.out.println("posiada konto bankowe z kwota:"+acount2.balance);
        System.out.println("Kredyt na kwote"+credit2.cashBorrowed);
        System.out.println("Jego adres to"+" "+person2.personAdres.City+person2.personAdres.street+" "+person2.personAdres.numberOfHome);
    }
}
