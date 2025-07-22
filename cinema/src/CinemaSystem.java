class CinemaSystem {
    public static void main(String[] args) {

        Moovie moovie1 = new Moovie("Omen", "horror", 128, 16, 72, 72);
        Client client1 = new Client("Jan", "Kowalski", 15);
        Ticket ticket1 = new Ticket(0, null, null);
    PrintInfo info1=new PrintInfo();
    info1.info(moovie1,ticket1,client1);

    Client client2=new Client("Anna","Zalewska",19);
        Ticket ticket2 = new Ticket(0, null, null);
        PrintInfo info2=new PrintInfo();
       info2.info(moovie1,ticket2,client2);
        System.out.println("Sprzedane bilety");
        if (ticket1.getTicketId() != 0) {
            System.out.println(ticket1.getTicketId() + " | " + ticket1.getTicketPersonData() + " | " + ticket1.getTicketMovieTitle() + " - " + moovie1.getMovieType() + " - " + moovie1.getMovieTime() + "min");
        }
        if (ticket2.getTicketId() != 0) {
            System.out.println(ticket2.getTicketId() + " | " + ticket2.getTicketPersonData() + " | " + ticket2.getTicketMovieTitle() + " - " + moovie1.getMovieType() + " - " + moovie1.getMovieTime() + "min");
        }


        System.out.println("Liczba pozostałych miejsc: " + moovie1.getFreeSeats());
        System.out.println("Liczba sprzedanych biletów: " + (moovie1.getMaxSeats()-moovie1.getFreeSeats()));
    }

        }





