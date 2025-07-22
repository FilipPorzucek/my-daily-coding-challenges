public class Hospital {

    private static final int MAX_PERSONS=3;

  private  Person[] persons=new Person[MAX_PERSONS];
  private int personNumber=0;

  void add(Person person){
    if(personNumber<MAX_PERSONS)
      persons[personNumber]=person;
    personNumber++;
  }
  String getInfo(){
    String result="";
    for (int i=0;i<personNumber;i++){
    result=result+persons[i].getInfo()+"\n";
    }
return result;
  }

}
