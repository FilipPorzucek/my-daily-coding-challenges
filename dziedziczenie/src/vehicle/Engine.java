package vehicle;

public class Engine {
    private int Power;
    private String Type;

    public Engine(int power, String type) {
        this.Power = power;
        this.Type = type;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
