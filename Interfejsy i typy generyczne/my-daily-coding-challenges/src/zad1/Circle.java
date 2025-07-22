package zad1;

public class Circle implements IShape,IDrawable{
    private int r;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public double Area() {
        return 2*Math.PI*r;
    }

    @Override
    public void Draw() {

    }
}
