// Salesperson.java
// Represents a salesperson, similar to the Contact class in the text.

public class Salesperson implements Comparable<Salesperson> {
    private String firstName, lastName;
    private int totalSales;

    public Salesperson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    public String toString() {
        return lastName + ", " + firstName + ":\t" + totalSales;
    }

    // TODO: lengkapi compareTo()
    @Override
    public int compareTo(Salesperson other) {
        return 0; // sementara
    }
}
