public class App {
    public static void main(String[] args) {
    Product product1=new Product("Jabłko",4.99);
    Product product2=new Product("Jabłko",4.99);
    Product product3=new Product("Jabłko",4.99);
Cart cart=new Cart();
cart.add(product1);
cart.add(product2);
cart.add(product3);
        System.out.println();

    }
}
