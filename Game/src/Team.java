public class Team {

    Character[] characters=new Character[3];
    private String name;

    public Team( String name,Character character1,Character  character2,Character  character3) {
        this.name = name;
        characters[0]=character1;
        characters[1]=character2;
        characters[2]=character3;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    double attack(){
        double attack=0;
        for(Character character:characters){

attack+=character.totalAttack();
        }
        return attack;
    }

    double deffense(){
        double deffense=0;
        for (Character character:characters){
            deffense+=character.totalDefense();
        }
        return deffense;
    }

    double energy(){
        double energy=0;
        for(Character characters:characters){
            energy+=characters.getEnergy();
        }
        return energy;
    }


}
