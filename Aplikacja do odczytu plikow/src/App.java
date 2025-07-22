import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final String fileName="clients.csv";
        try {
            Client[] clients=FileReader.readFile(fileName);
            printMostValuableClient(clients);
            String country=readClientFromCountry();
            printClientsFromCountry(clients,country);
            printAverageValueFromCountry(clients,country);

        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku o nazwie "+fileName);
        }


    }

    private static void printAverageValueFromCountry(Client[] clients, String country) {
        double totalValue=0;
        int clientsFromCountry=0;
        for (Client client : clients) {
            if(country.equals(client.getCountry())){
                totalValue+=client.getMoney();
                clientsFromCountry++;
            }
        }
        if(totalValue>0){
            double averageValue=totalValue/clientsFromCountry;
            System.out.printf("Średnia wartosc klienta z %s to %.2f",country,averageValue);;
        }
    }

    private static void printClientsFromCountry(Client[] clients, String country) {
        System.out.println("Klienci z kraju  "+country);
        boolean atLeastOneClient=false;
        for (Client client : clients) {
         if(country.equals(client.getCountry())) {
             System.out.println(client);
             atLeastOneClient = true;
         }
        }
        if(!atLeastOneClient){
            System.out.println("Brak klientów");
        }
    }

    private static String readClientFromCountry() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj nazwe kraju");
        return scanner.nextLine();
    }


    private static void printMostValuableClient(Client[] clients) {
        Client mostValuableClient=clients[0];
        for (Client client : clients) {
            if(client.getMoney()>mostValuableClient.getMoney()){
                mostValuableClient=client;
            }
        }
        System.out.println("Najbardziej wartosciowy klient to"+ mostValuableClient);
    }


}
