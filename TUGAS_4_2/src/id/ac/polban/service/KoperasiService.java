package id.ac.polban.service;

import id.ac.polban.model.*;
import java.util.*;

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
        Map<Produk, Integer> keranjang = new LinkedHashMap<>(); // produk + jumlah

        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\n==== KOPERASI ====");
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
                continue;
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
                continue;
            }

            Produk barang = menuDipilih.get(pilihan);

            // jumlah barang
            System.out.print("Masukkan jumlah beli: ");
            int jumlah = sc.nextInt();

            // masukkan ke keranjang (akumulasi kalau barang sudah ada)
            keranjang.put(barang, keranjang.getOrDefault(barang, 0) + jumlah);

            // tanya apakah mau transaksi lagi
            System.out.print("Apakah ingin transaksi lagi? (y/n): ");
            String jawab = sc.next();
            if (jawab.equalsIgnoreCase("n")) {
                lanjut = false;
            }
        }

        // setelah selesai, cetak struk total
        cetakStruk(keranjang);
    }

    private void cetakStruk(Map<Produk, Integer> keranjang) {
        System.out.println("\n===== STRUK BELANJA =====");
        double total = 0;
        int nomor = 1;

        for (Map.Entry<Produk, Integer> entry : keranjang.entrySet()) {
            Produk p = entry.getKey();
            int jumlah = entry.getValue();
            double subtotal = p.getHarga() * jumlah;

            System.out.println(nomor + ". " + p.getNama() + " x" + jumlah +
                               " = Rp" + subtotal);
            total += subtotal;
            nomor++;
        }

        System.out.println("-------------------------");
        System.out.println("TOTAL: Rp" + total);
        System.out.println("=========================\n");
    }
}
