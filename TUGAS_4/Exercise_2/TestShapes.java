public class TestShapes {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        System.out.println(s1);

        CircleShape c = new CircleShape(2.5, "blue", false);
        System.out.println(c);
        System.out.println(" area=" + c.getArea() + " perimeter=" + c.getPerimeter());

        Rectangle r = new Rectangle(2.0, 3.0, "yellow", true);
        System.out.println(r);
        System.out.println(" area=" + r.getArea() + " perimeter=" + r.getPerimeter());

        Square sq = new Square(4.0, "black", true);
        System.out.println(sq);
        System.out.println(" area=" + sq.getArea() + " perimeter=" + sq.getPerimeter());

        // test overridden setters
        sq.setWidth(5.0);
        System.out.println("after setWidth(5.0): " + sq);
    }
}
