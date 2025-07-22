public class Client {
    int index;
    String firstName;
    String lastName;
    String country;
    double money;

    public Client(int index, String firstName, String lastName, String country, double money) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Client{" +
                "index=" + index +
                ", firstName='" + firstName +
                ", lastName='" + lastName +
                ", country='" + country +
                ", money=" + money +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
