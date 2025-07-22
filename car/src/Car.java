public class Car {

    public static final int OK=100;
    public static final int ERROR_ENGINE=200;
    public static final int ERROR_NO_FUEL=300;
    public static final int WARNING_OPEN_FUEL_FLAP=400;
    public static final int WARNING_BACK_DOOR_OPEN=500;

    private static int fuelLevel;
    private static boolean engineWork;
    private static boolean fuelFlapClose;
    private static boolean doorsClose;
    private static boolean  engineWorking;

    public Car(int fuelLevel,boolean engineWork,boolean fuelFlapClose,boolean doorsClose,boolean engineWorking) {
        this.fuelLevel=fuelLevel;
        this.engineWork=engineWork;
        this.fuelFlapClose=fuelFlapClose;
        this.doorsClose=doorsClose;
        this.engineWorking=engineWorking;
    }

    public static int getFuelLevel() {
        return fuelLevel;
    }

    public static void setFuelLevel(int fuelLevel) {
        if(fuelLevel<=0){
            engineWork=false;
        }
    }

    public static boolean isEngineWork() {
        return engineWork;
    }

    public static void setEngineWork(boolean engineWork) {
        Car.engineWork = engineWork;
    }

    public static boolean isFuelFlapClose() {
        return fuelFlapClose;
    }

    public static void setFuelFlapClose(boolean fuelFlapClose) {
        Car.fuelFlapClose = fuelFlapClose;
    }

    public static boolean isDoorsClose() {
        return doorsClose;
    }

    public static void setDoorsClose(boolean doorsClose) {
        Car.doorsClose = doorsClose;
    }

    public static boolean isEngineWorking() {
        return engineWorking;
    }

    public static void setEngineWorking(boolean engineWorking) {
       int sys
    }
    int start(){
        int systemCheck=systemCheck();
        setEngineWork(true);
        return systemCheck();
    }
    private int systemCheck() {
        if (!engineWork)
            return ERROR_ENGINE;
        if (fuelLevel <= 0)
            return ERROR_NO_FUEL;
        if(!fuelFlapClose)
            return WARNING_OPEN_FUEL_FLAP;
        if(!doorsClose)
            return WARNING_BACK_DOOR_OPEN;
        return OK;

    }
}
