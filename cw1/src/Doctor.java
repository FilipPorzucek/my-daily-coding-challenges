public class Doctor extends Person{
    private int bonus;

    public Doctor(String name, String lastName, int salary, int bonus) {
        super(name, lastName, salary);
        this.bonus = bonus;
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"Premia"+bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
