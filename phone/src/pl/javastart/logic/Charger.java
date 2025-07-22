package pl.javastart.logic;

import pl.javastart.model.Telephone;

public class Charger {

    public void charg(Telephone telephone){
       int currentBaterry=telephone.getChargeLevel();
       telephone.setChargeLevel(currentBaterry+1);

    }

}
