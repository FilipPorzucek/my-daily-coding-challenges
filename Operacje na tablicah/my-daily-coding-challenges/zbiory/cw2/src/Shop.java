import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Shop {
    static Set<Product>products=new HashSet<>();
    static Scanner scanner=new Scanner(System.in);
    private static final int DISCARD_PRODUCT=0;
    private static final int REPLACE_PRODUCT=1;
    public static void main(String[] args) {




        int option= -1;
        while (option!=1) {
            System.out.println("0-dodaj nowy produkt ");
            System.out.println("1-wyjdz z programu");
            option=scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Dodaj nowy produkt");
                    Adder();

                    break;
                case 1:
                    printProducts();
                    break;
                default:
                    System.out.println("Nieznana opcja");
            }
        }

    }



    private static void Adder() {

        Product product=createProduct();
        if(products.contains(product)) {
           askAndReplaceProduct(product);
        }else {
            addProduct(product);
        }
    }

    private static void addProduct(Product product) {
        products.add(product);
        System.out.println("Dodano produkt");
    }
    private static void printProducts() {
        System.out.println("Oto wszystkie produkty");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void askAndReplaceProduct(Product product) {
        System.out.println("Znaleziono produkt o tej nazwie wybiezrz co chcesz zrobic");
        System.out.println("Zignoruj produkt -"+DISCARD_PRODUCT);
        System.out.println("Nadpisz produkt -"+REPLACE_PRODUCT);
        int option= scanner.nextInt();
        if (option==REPLACE_PRODUCT){
            products.remove(product);
            products.add(product);
        }else {
            System.out.println("Pozostawiono poprzedni produkt");
        }
    }

    private static Product createProduct() {
        System.out.println("Podaj nazwę produktu:");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Podaj cenę produktu:");
        int price=scanner.nextInt();
        scanner.nextLine();
        return new Product(name,price);
    }
}
