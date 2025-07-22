public class Car {
    private static final double FUEL_CONSUMPION=8;
    private final static double MAX_FUEL=50;
    private double fuel;
    public void refuel(double additionalFuel){
        if(fuel+additionalFuel>MAX_FUEL){
            throw new IllegalArgumentException("Nie mozna zatankowac tyle paliwa");
        }else
        fuel=+additionalFuel;
    }
    public void drive(){
        if(fuel-FUEL_CONSUMPION<0) {
            throw new IllegalStateException("Masz za mało paliwa");
        }else
        fuel -= FUEL_CONSUMPION;
    }

    @Override
    public String toString() {
        return "Stan paliwa "+fuel;
    }
}
