import java.util.Comparator;

public class Product implements Comparable<Product>{
    private String producent;
    private String name;
    private double price;

    public Product(String producent, String name, double price) {
        this.producent = producent;
        this.name = name;
        this.price = price;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [name"+name+", producer"+producent+", price"+price;
    }

    @Override
    public int compareTo(Product p) {
        if(price>p.price)
            return 1;
        else if (price<p.price)
            return -1;
      int producerCompare=producent.compareTo(p.producent);
      if(producerCompare!=0)
          return producerCompare;

        return this.name.compareTo(p.name);

    }

    static public class ProductNameComparator implements Comparator<Product> {

        @Override
        public int compare(Product p1, Product p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
