import java.io.*;

public class ObjectWritter {
    public static void main(String[] args) {
        String fileName="person.obj";
        Person p1=null;


        try(
                var fis=new FileInputStream(fileName);
                var ois=new ObjectInputStream(fis);
                ) {
            p1=(Person) ois.readObject();
        } catch (IOException|ClassNotFoundException e ) {
            System.out.println("Nie udalo sie odczytac pliku");
            e.printStackTrace();
        }
        if(p1!=null){
            System.out.println("Wczytano dane");
            System.out.println(p1.getFirstName()+" "+p1.getLastName());
        }
    }
}
