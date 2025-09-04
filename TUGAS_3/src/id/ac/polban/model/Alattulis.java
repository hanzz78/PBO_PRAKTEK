package PBOPRAKTEK2;

public class Alattulis {
    private String nama;
    private double harga;

    public Alattulis(String nama, double harga){
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama(){
        return nama;
    }

    public double getHarga(){
        return harga;
    }

    public void tampilkanInfo(int index){
        System.out.println((index+1) + ". " + nama + " | Rp" + harga);
    }
}
