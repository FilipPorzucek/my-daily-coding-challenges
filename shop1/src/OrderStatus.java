public enum OrderStatus {
    NEW("Złożone"),PAID("Opłacone"),SHIPED("Wysłane"),
    DELIVERD("Dostarczone"),CANCELED("Anulowane");

    private final String status;

    OrderStatus(String status){
        this.status=status;
    }

    public String getType() {
        return status;
    }


}
