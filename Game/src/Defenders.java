public class Defenders extends  Character{
private double extraDefense;


    public Defenders(String name, int power, int powerDefense, int energy,double extraDefense) {
        super(name, power, powerDefense, energy);
        this.extraDefense=extraDefense;
    }

    @Override
    double totalDefense() {
        return getPowerDefense()+extraDefense*getPowerDefense();
    }

    public double getExtraDefense() {
        return extraDefense;
    }

    public void setExtraDefense(double extraDefense) {
        this.extraDefense = extraDefense;
    }
}
