public class Character {
    private String name;
    private int powerAttack;
    private int powerDefense;
    private int energy;

    public Character(String name, int power, int powerDefense, int energy) {
        this.name = name;
        this.powerAttack = power;
        this.powerDefense = powerDefense;
        this.energy = energy;
    }
    double totalAttack(){
        return powerAttack;
    }
    double totalDefense(){
        return powerDefense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerAttack() {
        return powerAttack;
    }

    public void setPowerAttack(int powerAttack) {
        this.powerAttack = powerAttack;
    }

    public int getPowerDefense() {
        return powerDefense;
    }

    public void setPowerDefense(int powerDefense) {
        this.powerDefense = powerDefense;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
