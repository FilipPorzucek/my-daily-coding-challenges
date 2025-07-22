public class Cart {
    Product[] products=new Product[10];
    public int ID;

    void add(Product newProduct) {
        if (ID < 10) {
            products[ID] = newProduct;
            ID++;
        } else System.out.println("Koszyk jest pełen");
    }
double totalCost(){

return sumPrices(0);
}

private double sumPrices(int counter){
        if(ID==0){
            return 0;
        }else {
            if (counter < (ID - 1)) {
                return products[counter].getPrice() + sumPrices(++counter);
            } else {
                return products[counter].getPrice();
            }
        }
}
}
