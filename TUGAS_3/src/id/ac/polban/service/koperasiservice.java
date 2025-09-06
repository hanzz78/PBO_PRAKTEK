package id.ac.polban.service;

import id.ac.polban.model.Makanan;
import id.ac.polban.model.AlatTulis;
import java.util.Scanner;

public class KoperasiService {

    private Makanan[] menuMakanan;
    private AlatTulis[] menuAlatTulis;

    public KoperasiService() {
        menuMakanan = new Makanan[] {
            new Makanan("Nasi Goreng", 15000),
            new Makanan("Mie Goreng", 12000),
            new Makanan("Sate Ayam", 20000)
        };

        menuAlatTulis = new AlatTulis[] {
            new AlatTulis("Bolpoin", 3000),
            new AlatTulis("Pensil", 2000),
            new AlatTulis("Buku Tulis", 5000)
        };
    }

    public void jalankan() {
        Scanner input = new Scanner(System.in);

        System.out.println("---- SELAMAT DATANG DI KOPERASI ----");
        System.out.println("1. Makanan");
        System.out.println("2. Alat Tulis");
        System.out.print("Pilih kategori = ");
        int pilihan = input.nextInt();

        if (pilihan == 1) {
            tampilkanMenuMakanan();
            System.out.print("Pilih nomor makanan: ");
            int pilihMakanan = input.nextInt() - 1;

            if (pilihMakanan >= 0 && pilihMakanan < menuMakanan.length) {
                System.out.println("Anda membeli: " + menuMakanan[pilihMakanan].getNama() +
                                   " seharga Rp" + menuMakanan[pilihMakanan].getHarga());
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        } else if (pilihan == 2) {
            tampilkanMenuAlatTulis();
            System.out.print("Pilih nomor alat tulis: ");
            int pilihAlat = input.nextInt() - 1;

            if (pilihAlat >= 0 && pilihAlat < menuAlatTulis.length) {
                System.out.println("Anda membeli: " + menuAlatTulis[pilihAlat].getNama() +
                                   " seharga Rp" + menuAlatTulis[pilihAlat].getHarga());
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        } else {
            System.out.println("Kategori tidak ada!");
        }

        input.close();
    }

    private void tampilkanMenuMakanan() {
        System.out.println("=== Menu Makanan ===");
        for (int i = 0; i < menuMakanan.length; i++) {
            menuMakanan[i].tampilkanInfo(i);
        }
    }

    private void tampilkanMenuAlatTulis() {
        System.out.println("=== Menu Alat Tulis ===");
        for (int i = 0; i < menuAlatTulis.length; i++) {
            menuAlatTulis[i].tampilkanInfo(i);
        }
    }
}
