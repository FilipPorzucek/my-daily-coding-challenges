package vehicle;

public class Car extends WheelVehicle {
  private int doors;

  public int getDoors() {
    return doors;
  }

  public void setDoors(int doors) {
    this.doors = doors;
  }

  void printInfp(){
    System.out.println("Samochód"+getEngine().getType()+"Koła"+getWheels());
  }
}
