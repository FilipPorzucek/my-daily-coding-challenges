public class Atackers extends Character{
private double extraAttack;

    public Atackers(String name, int powerAttack, int powerDefense, int energy,double extraAttack) {
        super(name, powerAttack, powerDefense, energy);
        this.extraAttack=extraAttack;
    }

    @Override
    double totalAttack() {
        return getPowerAttack()+extraAttack*getPowerAttack();
    }

    public double getExtraAttack() {
        return extraAttack;
    }

    public void setExtraAttack(double extraAttack) {
        this.extraAttack = extraAttack;
    }
}
