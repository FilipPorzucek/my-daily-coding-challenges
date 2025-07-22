public class ClientInfo {

    void printInfo(Client client,double price){

        if(client.getLastName()==null){
            System.out.println("Witaj Jan"+" "+client.getLastName()+" "+price);

        } else if (client.getLastName()!=null && client.getLastName()!=null) {
            System.out.println("Witaj "+client.getLastName()+client.getFirstName()+" "+price);

        } else if (client.getFirstName()==null) {
            System.out.println("Dzien dobry panie/pani Kowalski"+" "+price);

        } else {

            System.out.println("Witaj nieznajomy"+" "+price);
        }
    }


}
