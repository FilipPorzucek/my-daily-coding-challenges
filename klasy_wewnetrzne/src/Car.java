public class Car {
    private static  int fuel;
    private Engine engine;

    public Car() {
        engine=new Engine("Ferrari");
        System.out.println("Utworzono samochód z silnikiem"+engine.engineType);
    }

    public void go() throws InterruptedException{
        while (fuel>0){
          engine.consumeFuel();
            System.out.println("Pozostalo"+fuel);
            Thread.sleep(3000);
        }
        System.out.println("Brak paliwa");
    }

    public void refuel(int liters){
        fuel=fuel+liters;
    }


    public static class Engine{
        private String engineType;
        private static final int FUEL_CONSUMPTION=20;

        public Engine(String engineType) {
            this.engineType = engineType;
        }

         public void consumeFuel(){
            if(fuel>=FUEL_CONSUMPTION)
            fuel=fuel-FUEL_CONSUMPTION;
            else fuel=0;
         }
    }

}
