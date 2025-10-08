// Rectangle.java
public class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double l, double w) {
        super("Rectangle");
        length = l;
        width = w;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return super.toString() + " length: " + length + " width: " + width;
    }
}
