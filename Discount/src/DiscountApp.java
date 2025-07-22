public class DiscountApp {
    public static void main(String[] args) {
        Client client1=new Client("Jan",null,true);

        double price=1100;
        DiscountServis discountServis=new DiscountServis();
        double discountPrice=discountServis.calculateDiscountPice(client1,price);


        ClientInfo info=new ClientInfo();
       info.printInfo(client1,price);

        System.out.println("Do zaplaty po rabacie"+" "+discountPrice);

        Client client2=new Client("Karol",null,true);
        double price2=900;
        double discountPrice2=discountServis.calculateDiscountPice(client2,price2);


info.printInfo(client2,price2);
        System.out.println("Kwota przed obnizka"+" "+price2);
        System.out.println("Do zaplaty po rabacie"+" "+discountPrice2);
    }
}
