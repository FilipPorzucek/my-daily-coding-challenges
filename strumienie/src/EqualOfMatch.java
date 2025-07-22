public class EqualOfMatch {

private String nameOfHosts;
private String nameOfguests;
private int numberOfHostsGoals;
private int numberOfGoalsGuests;


    public EqualOfMatch(String nameOfHosts, String nameOfguests, int numberOfHostsGoals, int numberOfGoalsGuests) {
        this.nameOfHosts = nameOfHosts;
        this.nameOfguests = nameOfguests;
        this.numberOfHostsGoals = numberOfHostsGoals;
        this.numberOfGoalsGuests = numberOfGoalsGuests;
    }

    public String getNameOfHosts() {
        return nameOfHosts;
    }

    public void setNameOfHosts(String nameOfHosts) {
        this.nameOfHosts = nameOfHosts;
    }

    public String getNameOfguests() {
        return nameOfguests;
    }

    public void setNameOfguests(String nameOfguests) {
        this.nameOfguests = nameOfguests;
    }

    public int getNumberOfHostsGoals() {
        return numberOfHostsGoals;
    }

    public void setNumberOfHostsGoals(int numberOfHostsGoals) {
        this.numberOfHostsGoals = numberOfHostsGoals;
    }

    public int getNumberOfGoalsGuests() {
        return numberOfGoalsGuests;
    }

    public void setNumberOfGoalsGuests(int numberOfGoalsGuests) {
        this.numberOfGoalsGuests = numberOfGoalsGuests;
    }

    boolean containsTeam(String team){
        return nameOfHosts.equals(team) || nameOfguests.equals(team);
    }

    String[] getTeamNames(){
        return new String[]{nameOfHosts,nameOfguests};
    }

    int getGoalsSum(){
        return numberOfGoalsGuests+numberOfHostsGoals;
    }

    @Override
    public String toString() {
        return
                nameOfHosts + "-" +
                  nameOfguests +"  "
                + numberOfHostsGoals +"-"+
                numberOfGoalsGuests
              ;
    }
}
