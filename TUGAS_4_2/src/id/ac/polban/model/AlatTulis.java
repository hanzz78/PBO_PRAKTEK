package id.ac.polban.model;

public class AlatTulis extends Produk {
    private String warna;

    public AlatTulis(String nama, double harga, String warna) {
        super(nama, harga); // memanggil constructor Produk
        this.warna = warna;
    }

    public String getWarna() {
        return warna;
    }

    @Override
    public void tampilkanInfo(int index) {
        // override method tampilkanInfo
        System.out.println((index + 1) + ". " + getNama() + " | Rp" + getHarga() + " | Warna: " + warna);
    }
}
