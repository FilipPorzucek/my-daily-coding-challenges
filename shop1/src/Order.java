public class Order {

    String item;
    int cena;
    OrderStatus orderStatus;

    public Order(String item,int cena,OrderStatus orderStatus){
        this.item=item;
        this.cena=cena;
        this.orderStatus=orderStatus;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return item+"("+cena+")"+"-"+orderStatus.getType();
    }
}
