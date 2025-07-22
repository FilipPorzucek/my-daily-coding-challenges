package zad4;

public class App {
    public static void main(String[] args) {
        Person[] people=new Person[3];
        people[0]=new Person("Jasiu",23);
        people[1]=new Person("Franciszek",87);
        people[2]=new Person("Filip",82);
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
