package id.ac.polban.model;

public class Makanan {
    private final String nama;
    private final double harga;

    public Makanan(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public void tampilkanInfo(int index) {
        System.out.println((index + 1) + ". " + nama + " | Rp" + harga);
    }
}
