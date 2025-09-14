package id.ac.polban.model;

public class Makanan extends Produk {
    private boolean pedas;

    public Makanan(String nama, double harga, boolean pedas) {
        super(nama, harga); // memanggil constructor Produk
        this.pedas = pedas;
    }

    public boolean isPedas() {
        return pedas;
    }

    @Override
    public void tampilkanInfo(int index) {
        // override method tampilkanInfo
        String level = pedas ? " (Pedas)" : "";
        System.out.println((index + 1) + ". " + getNama() + " | Rp" + getHarga() + level);
    }
}
