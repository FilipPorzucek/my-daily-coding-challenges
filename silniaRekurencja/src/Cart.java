import java.util.Arrays;

public class Cart {
    Product[] products=new Product[10];
    public static int ID=0;

  void add(Product newProduct) {
      if (ID < 10) {
          products[ID] = newProduct;
          ID++;
      } else System.out.println("Koszyk jest pełen");
  }


}
