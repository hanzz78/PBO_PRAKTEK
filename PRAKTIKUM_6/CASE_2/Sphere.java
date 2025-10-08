// Sphere.java
public class Sphere extends Shape {
    private double radius;

    public Sphere(double r) {
        super("Sphere");   // ini butuh constructor Shape(String)
        radius = r;
    }

    @Override
    public double area() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString() + " radius: " + radius;
    }
}
