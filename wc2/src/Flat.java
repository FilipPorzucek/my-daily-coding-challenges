public class Flat implements Comparable<Flat> {
    private String city;
    private Double price;
    private Double area;



    @Override
    public String toString() {
        return city+" "+price+" "+area+" "+
                String.format("%.2f",getPricePerSqrm());
    }

    public Flat(String city, Double price, Double area) {
        this.city = city;
        this.price = price;
        this.area = area;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    double getPricePerSqrm(){
        return price/area;
    }

    @Override
    public int compareTo(Flat o) {
     return   Double.compare(getPricePerSqrm(),o.getPricePerSqrm());


    }
}
