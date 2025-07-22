public class HomeStuff {
    double water;
    double rope;

    HomeStuff(double w, double r){
        water=w;
        rope=r;
    }

    String status(){
     return "Stan wody to"+" "+water+","+"stam ropy to:"+" "+rope;
    }

    void takeShower(){
     water=water-48;
    }

    void takeBath(){
       water=water-86;
    }

    void makeDinner(){
        rope=rope-0.1;
        water=water-4;
    }
    void  boilWater(){
        rope=rope-0.05;
        water=water-0.5;
    }

    void watchTv(int hours){
      double time=hours*0.06;
      rope=rope-time;
    }



}
