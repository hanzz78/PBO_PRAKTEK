package Exercise_1;
public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super(); // Circle()
        this.height = 1.0;
    }

    public Cylinder(double height) {
        super(); // Circle()
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius); // Circle(radius)
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double h) {
        height = h;
    }

    // Override: surface area of the cylinder
    @Override
    public double getArea() {
        double r = getRadius();
        double baseArea = super.getArea();
        double lateral = 2 * Math.PI * r * height;
        return lateral + 2 * baseArea; // surface area
    }

    // getVolume must use base area (circle area), so call super.getArea()
    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder: subclass of " + super.toString() + " height=" + height;
    }
}
