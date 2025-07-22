public class Computer {
    private String name;
    private int cpu;
    private int temperature;


    public Computer(String name, int cpu, int temperature) {
        this.name = name;
        this.cpu = cpu;
        this.temperature = temperature;
    }





    static void overclock(Computer computer){
        computer.cpu*=1.1;
        computer.temperature*=1.1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
