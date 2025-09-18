public class Goods {
    private String description;
    private double price;

    // Constructor
    public Goods(String description, double price) {
        this.description = description;
        this.price = price;
    }

    // Getter & Setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Display method
    public void display() {
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
    }
}
