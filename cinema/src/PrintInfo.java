public class PrintInfo {


    void info(Moovie moovie,Ticket ticket,Client client) {
        if (moovie.getFreeSeats() == 0) {
            System.out.println("Brak wolnych miejsc na seans");
        } else if (client.age < moovie.ageRequired) {
            System.out.println("Film dostępny dla osób powyżej " + moovie.ageRequired + " lat");
        } else {
            ticket.setTicketId(1);
            ticket.setTicketPersonData(client.firstName + " " + client.lastName);
            ticket.setTicketMovieTitle("Omen");
            moovie.setFreeSeats(moovie.getFreeSeats() - 1);
        }
    }
}
