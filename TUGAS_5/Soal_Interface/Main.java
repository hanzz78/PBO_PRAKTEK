public class Main {
    public static void main(String[] args) {
        Food food = new Food("Pizza", 50.0, 800);
        Toy toy = new Toy("Lego", 150.0, 6);
        Book book = new Book("Java Programming", 200.0, "John Doe");

        System.out.println("=== Food ===");
        food.display();

        System.out.println("\n=== Toy ===");
        toy.display();

        System.out.println("\n=== Book ===");
        book.display();
    }
}
