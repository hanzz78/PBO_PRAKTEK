package Exercise_1;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println("c1: " + c1.toString());
        System.out.println(" radius=" + c1.getRadius() + " height=" + c1.getHeight()
            + " base area=" + c1.getVolume()/c1.getHeight()
            + " surface area=" + c1.getArea()
            + " volume=" + c1.getVolume());

        Cylinder c2 = new Cylinder(10.0);
        System.out.println("\nc2: " + c2.toString());
        System.out.println(" radius=" + c2.getRadius() + " height=" + c2.getHeight()
            + " base area=" + c2.getVolume()/c2.getHeight()
            + " surface area=" + c2.getArea()
            + " volume=" + c2.getVolume());

        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("\nc3: " + c3.toString());
        System.out.println(" radius=" + c3.getRadius() + " height=" + c3.getHeight()
            + " base area=" + c3.getVolume()/c3.getHeight()
            + " surface area=" + c3.getArea()
            + " volume=" + c3.getVolume());
    }
}
