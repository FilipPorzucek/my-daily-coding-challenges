public class CompoterStore {
    public static void main(String[] args) {
        Computer computer=new Computer(45,16);


        Notebook notebook=new Notebook(40,8192,1000);
        notebook.coolDown();
        System.out.println(notebook.getCpuTemperature());
        System.out.println(notebook.getRemMemomory());
        System.out.println(notebook.getBatteryCapacity());

    }
}
