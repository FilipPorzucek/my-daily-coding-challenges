import java.util.Scanner;

public class temperatureRegulation {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double actualTemperature;
        double expectTemperature;

        System.out.println("Podaj aktualną temperaturę");
        actualTemperature=input.nextInt();
        System.out.println("Podaj oczekiwaną temperaturę");
        expectTemperature=input.nextInt();

        if(actualTemperature<expectTemperature){
            while (actualTemperature!=expectTemperature){
                actualTemperature=actualTemperature+0.5;
                System.out.println(actualTemperature);
            }
        } else if (actualTemperature>expectTemperature) {
            while (actualTemperature!=expectTemperature){
                actualTemperature=actualTemperature-0.5;
                System.out.println(actualTemperature);
            }

        }


    }
}
