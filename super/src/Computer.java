public class Computer {
    private double cpuTemperature;
    private int remMemomory;



    public Computer(double cpuTemperature, int remMemomory) {
        this.cpuTemperature = cpuTemperature;
        this.remMemomory = remMemomory;
    }

    public double getCpuTemperature() {
        return cpuTemperature;
    }

    public void setCpuTemperature(double cpuTemperature) {
        this.cpuTemperature = cpuTemperature;
    }

    public int getRemMemomory() {
        return remMemomory;
    }

    public void setRemMemomory(int remMemomory) {
        this.remMemomory = remMemomory;
    }

    public void  coolDown(){
        cpuTemperature=cpuTemperature-1;
    }
}
