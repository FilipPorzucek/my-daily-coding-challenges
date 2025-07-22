public class Home {
    public static void main(String[] args) {
    HomeStuff home1=new HomeStuff(10000,1000);
        System.out.println(home1.status());
        home1.takeShower();
        System.out.println(home1.status());
        home1.watchTv(4);
        System.out.println(home1.status());

    }
}
