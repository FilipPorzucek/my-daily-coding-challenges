public class World {
    public static void main(String[] args) {
        Human adam=new Human("Adam",186.5);
        Human eve=new Human("Ewa",167.5);


        Human.avgHeight= (adam.getHeight()+ eve.getHeight())/2;
        System.out.println("Sredni wzrost ludzi na siwecie to");
        System.out.println(Human.avgHeight);

    }
}
