import java.util.Arrays;

public class PersonDatabase {
    static int MAX_PERSON=1;

    Person[] people=new Person[MAX_PERSON];
    private int emptyPlace=0;


   public void add(Person p) {
if(p==null) {
    throw new NullPointerException("Person cannot be null");
}
    if(emptyPlace==people.length){
    people= Arrays.copyOf(people,people.length*2);
    }
    people[emptyPlace]=p;
    emptyPlace++;

   }
   void remove(Person person){
       if(person==null) {
           throw new NullPointerException("Person cannot be null");
       }
       final int notFound=-1;
       int foundIndex=notFound;
       for (int i = 0; i < emptyPlace && foundIndex==notFound; i++) {
           if(person.equals(people[i])){
                foundIndex=i;
           }
       }

       if(foundIndex!=notFound){
           System.arraycopy(people,foundIndex+1,people,foundIndex,people.length-foundIndex-1);
           emptyPlace--;
           people[emptyPlace]=null;
       }

   }


   Person get(int index){
       if(index>=emptyPlace || emptyPlace<0)
           throw new ArrayIndexOutOfBoundsException("Index has to be psitive number and lower than"+emptyPlace);
       return people[index];
   }
   int size(){
       return emptyPlace;
   }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("PeatsonDetabase sie to"+emptyPlace);
        sb.append("\n");
        for(int i=0;i<emptyPlace;i++){
            sb.append(">");
            sb.append(people[i].toString());
            sb.append("n");
        }
        return sb.toString();
    }
}
