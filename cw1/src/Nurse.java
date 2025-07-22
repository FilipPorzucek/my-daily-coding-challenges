public class Nurse extends Person{
    private int overTime;

    public Nurse(String name, String lastName, int salary, int overTime) {
        super(name, lastName, salary);
        this.overTime = overTime;
    }

    @Override
    public String getInfo() {
        return super.getInfo()+"Nadgodziny"+overTime;
    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }
}
