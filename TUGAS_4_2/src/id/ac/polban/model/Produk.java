package id.ac.polban.model;

public class Produk {
    protected String nama;
    protected double harga;

    public Produk(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    // method yang akan dioverride oleh subclass
    public void tampilkanInfo(int index) {
        System.out.println((index + 1) + ". " + nama + " | Rp" + harga);
    }
}
