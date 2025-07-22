package logic;

import data.Point;

public class pointController {

public void addX(Point point){
    int valueX=point.getX();
    point.setX(valueX+1);
}
  public  void minusX(Point point){
      int valueX=point.getX();
      point.setX(valueX-1);
   }
public void  addY(Point point){
       int valueY=point.getY();
       point.setY(valueY+1);
}
public void  minusY(Point point){
       int valueY=point.getY();
       point.setY(valueY-1);
}



}
