public class Notebook extends Computer{
private int batteryCapacity;

    public Notebook(double cpuTemperature, int remMemomory, int batteryCapacity) {
        super(cpuTemperature, remMemomory);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void coolDown() {
        super.coolDown();
        turboCool();
    }

    private void turboCool() {
        setCpuTemperature(getCpuTemperature()-2);
    }
}
