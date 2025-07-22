public class Battle {
    static void fight(Team team1,Team team2){
        double team2Energy=attack(team1,team2);
        double team1Energy=attack(team2,team1);
        double energyDiff=team1Energy-team2Energy;
        if(energyDiff>0){
            System.out.println("Wygrywa druzyna"+team1.getName());
        }else if(energyDiff<0){
            System.out.println("Wygrywa druzyna"+team2.getName());
        }else{
            System.out.println("Remis");
        }


    }
    private static double attack(Team attacker,Team deffender){

        double attack=attacker.attack();
        double defense=deffender.deffense();
        double attackPower=attack-defense;
        double energy=deffender.energy();
        if(attack>0){
         double result= energy-attackPower;
         return result>=0? result:0 ;
        }else {
            return energy;
        }


    }
}
