package pl.javastart.application;

import pl.javastart.logic.Charger;
import pl.javastart.model.Telephone;

public class PhoneTest {
    public static void main(String[] args) {
        Telephone telephone = new Telephone("Samsung", "Galaxy S10", 3400, 75);
        Charger charger=new Charger();
        telephone.info();
        charger.charg(telephone);
        telephone.info();

    }
}
