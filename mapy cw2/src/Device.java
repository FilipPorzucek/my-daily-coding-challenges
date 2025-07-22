import java.util.Objects;

public class Device implements Comparable<Device> {
    private String category;
    private String name;
    private int price;

    public Device(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(category, device.category);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(category);
    }

    @Override
    public String toString() {
        return category+" "+name+" "+price;
    }

    @Override
    public int compareTo(Device o) {
        return Double.compare(this.price,o.price);
    }
}
