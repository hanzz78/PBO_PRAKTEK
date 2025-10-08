// Paint.java
public class Paint {
    private double coverage; // luas yang bisa ditutupi per galon cat

    public Paint(double c) {
        coverage = c;
    }

    public double amount(Shape s) {
        System.out.println("Computing amount for " + s);
        // perbaikan return statement
        return s.area() / coverage;
    }
}
