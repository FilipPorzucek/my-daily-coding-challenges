import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {

        Order[] orders = createOrders();
        OrderStatus orderStatus=readStatus();
        Order[] filteredOrders=filterOrdersBStatus(orders,orderStatus);
        printOrders(filteredOrders,orderStatus);
    }

    private static void printOrders(Order[] orders, OrderStatus orderStatus) {
        System.out.println("Lista zamowien ze statusem"+orderStatus);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    private static Order[] createOrders() {
        Order[] orders = new Order[7];
        orders[0]=new Order("Komputer Apple Macbook",499,OrderStatus.PAID);
        orders[1]=new Order("Komputer Apple Macbook",499,OrderStatus.CANCELED);
        orders[2]=new Order("Komputer Apple Macbook",499,OrderStatus.CANCELED);
        orders[3]=new Order("Komputer Apple Macbook",499,OrderStatus.DELIVERD);
        orders[4]=new Order("Komputer Apple Macbook",499,OrderStatus.SHIPED);
        orders[5]=new Order("Komputer Apple Macbook",499,OrderStatus.NEW);
        orders[6]=new Order("Komputer Apple Macbook",499,OrderStatus.DELIVERD);
        return orders;
    }

    private static Order[] filterOrdersBStatus(Order[] orders,OrderStatus orderStatus){
        int size=countOrderByStatus(orders,orderStatus);

        Order[] orderByStatus=new Order[size];
        int counter=0;
        for (Order order : orders) {
            if(order.getOrderStatus()==orderStatus){
                orderByStatus[counter]=order;
                counter++;
            }
        }
        return orderByStatus;
        
    }

    private static int countOrderByStatus(Order[] orders, OrderStatus orderStatus) {
        int count=0;
        for (Order order : orders) {
            if (order.getOrderStatus() == orderStatus)
                count++;
        }
        return count;
    }


    private static OrderStatus readStatus() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Podaj status zamowien do wyswietlenia");
        for (OrderStatus os : OrderStatus.values()) {
            System.out.println(os.name()+" ");
        }

        String status=sc.nextLine();
        return OrderStatus.valueOf(status);
    }




}
