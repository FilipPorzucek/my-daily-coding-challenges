public class DatabaseTest {
    public static void main(String[] args) {
        PersonDatabase personDatabase=new PersonDatabase();
        personDatabase.add(new Person("Jan","Kowalski","1234"));
        personDatabase.add(new Person("Damian","Pelny","1432"));
        personDatabase.add(new Person("Damian","asd","8888"));
        personDatabase.add(new Person("Damian","Pdfgdy","7777"));
       Person person= personDatabase.get(1);
        System.out.println(person);
        System.out.println(personDatabase);

        personDatabase.remove(new Person("Damian","Pelny","1432"));
        System.out.println();
        System.out.println(personDatabase);


    }
}
