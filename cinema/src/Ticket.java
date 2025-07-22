public class Ticket {
    int ticketId;
    String ticketPersonData;
    String ticketMovieTitle;

    Ticket(int ticketId,String ticketPersonData,String ticketMovieTitle){
        this.ticketId=ticketId;
        this.ticketPersonData=ticketPersonData;
        this.ticketMovieTitle=ticketMovieTitle;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketPersonData() {
        return ticketPersonData;
    }

    public void setTicketPersonData(String ticketPersonData) {
        this.ticketPersonData = ticketPersonData;
    }

    public String getTicketMovieTitle() {
        return ticketMovieTitle;
    }

    public void setTicketMovieTitle(String ticketMovieTitle) {
        this.ticketMovieTitle = ticketMovieTitle;
    }
}
