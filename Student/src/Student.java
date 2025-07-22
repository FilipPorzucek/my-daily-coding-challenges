public class Student {
    public String name;
    public String Lastname;
    public int index;


    public Student(String name, String lastname, int index) {
        this.name = name;
        Lastname = lastname;
        this.index = index;
    }
    public void PrzedstawSie(){
        System.out.println(name+" "+Lastname+" "+index);
    }
}
