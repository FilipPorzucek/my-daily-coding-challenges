public class carShop {
    public static void main(String[] args) {


    Car car1=new Car();


    car1.brand="Audi";
    car1.model="A4";
    car1.color="Czarny";
    car1.wheelsColor="Srebrny";
    car1.triesColor="Czarny";
    car1.doors=5;
    String car1Info=car1.brand+","+car1.model+","+"kolor:"+car1.color+"kolor kołpaków:"+ car1.wheelsColor
            +"kolor opon:"+car1.triesColor+","+car1.doors;



        System.out.println(car1Info);





    }
}
