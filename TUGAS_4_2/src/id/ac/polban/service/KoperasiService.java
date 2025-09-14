package id.ac.polban.service;

import id.ac.polban.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KoperasiService {
    private List<Makanan> menuMakanan = new ArrayList<>();
    private List<AlatTulis> menuAlatTulis = new ArrayList<>();

    public KoperasiService() {
        menuMakanan.add(new Makanan("Nasi Goreng", 15000, true));
        menuMakanan.add(new Makanan("Mie Goreng", 12000, false));

        menuAlatTulis.add(new AlatTulis("Bolpoin", 3000, "Biru"));
        menuAlatTulis.add(new AlatTulis("Pensil", 2000, "Hitam"));
    }

    public void tampilkanMenu() {
        Scanner sc = new Scanner(System.in);
        List<Produk> keranjang = new ArrayList<>();

        System.out.println("==== KOPERASI ====");
        System.out.println("1. Makanan");
        System.out.println("2. Alat Tulis");
        System.out.print("Pilih kategori: ");
        int kategori = sc.nextInt();

        List<? extends Produk> menuDipilih = null;
        if (kategori == 1) {
            menuDipilih = menuMakanan;
            System.out.println("---- MENU MAKANAN ----");
        } else if (kategori == 2) {
            menuDipilih = menuAlatTulis;
            System.out.println("---- MENU ALAT TULIS ----");
        } else {
            System.out.println("Kategori tidak ada.");
            return;
        }

        // tampilkan semua item
        for (int i = 0; i < menuDipilih.size(); i++) {
            menuDipilih.get(i).tampilkanInfo(i);
        }

        // pilih barang
        System.out.print("Pilih nomor barang: ");
        int pilihan = sc.nextInt() - 1;

        if (pilihan < 0 || pilihan >= menuDipilih.size()) {
            System.out.println("Barang tidak ditemukan!");
            return;
        }

        Produk barang = menuDipilih.get(pilihan);

        // jumlah barang
        System.out.print("Masukkan jumlah beli: ");
        int jumlah = sc.nextInt();

        // masukkan ke keranjang sesuai jumlah
        for (int i = 0; i < jumlah; i++) {
            keranjang.add(barang);
        }

        // cetak struk
        cetakStruk(keranjang);
    }

    private void cetakStruk(List<Produk> keranjang) {
        System.out.println("\n===== STRUK BELANJA =====");
        double total = 0;
        for (int i = 0; i < keranjang.size(); i++) {
            Produk p = keranjang.get(i);
            System.out.println((i+1) + ". " + p.getNama() + " - Rp" + p.getHarga());
            total += p.getHarga();
        }
        System.out.println("-------------------------");
        System.out.println("TOTAL: Rp" + total);
        System.out.println("=========================\n");
    }
}
