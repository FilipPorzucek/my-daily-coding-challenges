public class Dog  extends Animal{
    public Dog(String name) {
        super(name);
    }

    public void bark(){
        System.out.println("HAUHAU");
    }

    @Override
    public void giveSound() {
        System.out.println("Jestem zwierzeciem i nazywam sie"+getName());
    }
}
