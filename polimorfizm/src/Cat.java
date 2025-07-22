public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }


    public void meow(){
        System.out.println("MEOWMEOW");
    }
    @Override
    public void giveSound() {
        System.out.println("Jestem kotem i zazywam sie"+getName());
    }
}
