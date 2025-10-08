// PaintThings.java
public class PaintThings {
    public static void main(String[] args) {
        final double COVERAGE = 350; // 1 galon cat menutupi 350 sq ft

        Paint paint = new Paint(COVERAGE);

        // buat objek bentuk
        Rectangle deck = new Rectangle(20, 35);
        Sphere bigBall = new Sphere(15);
        Cylinder tank = new Cylinder(10, 30);

        // hitung jumlah cat
        double deckAmt = paint.amount(deck);
        double ballAmt = paint.amount(bigBall);
        double tankAmt = paint.amount(tank);

        // cetak hasil
        System.out.println("\nAmount of paint needed:");
        System.out.println("Deck: " + deckAmt);
        System.out.println("Big Ball: " + ballAmt);
        System.out.println("Tank: " + tankAmt);
    }
}
