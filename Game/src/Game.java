public class Game {
    public static void main(String[] args) {
        Atackers character1=new Atackers("Joe",100,100,100,0.5);
        Atackers character2=new Atackers("Martha",100,100,100,0.2);
        Defenders character3=new Defenders("Matt",100,100,100,0.2);
        Atackers character4=new Atackers("Matt",100,100,100,0.2);
        Atackers character5=new Atackers("Matt",100,100,100,0.2);
        Defenders character6=new Defenders("Matt",100,100,100,0.8);

        Team team1=new Team("TeamOne",character1,character2,character3);
        Team team2=new Team("TeamTwo",character4,character5,character6);
        Battle.fight(team1,team2);
    }
}
