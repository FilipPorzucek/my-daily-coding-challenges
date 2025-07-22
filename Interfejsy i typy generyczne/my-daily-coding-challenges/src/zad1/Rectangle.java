package zad1;

public class Rectangle implements IShape,IDrawable{
private double width;
private double height;
    @Override
    public double Area() {
        return height+height+width+width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void Draw() {

    }
}
