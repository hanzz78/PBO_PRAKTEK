package id.ac.polban.service;

import id.ac.polban.model.Makanan;
import id.ac.polban.model.AlatTulis;
import java.util.Scanner;

public class KoperasiService {
    private static Scanner input = new Scanner(System.in); // static supaya bisa dipakai tanpa objek

    public static void mulai() {
        Makanan[] menuMakanan = {
            new Makanan("Nasi Goreng", 15000),
            new Makanan("Mie Goreng", 20000)
        };

        AlatTulis[] menuAlatTulis = {
            new AlatTulis("Bolpoin", 5000),
            new AlatTulis("Pensil", 3000)
        };

        System.out.println("=== SELAMAT DATANG DI KOPERASI KELUARGA SEHAT ===");
        System.out.println("1. Makanan");
        System.out.println("2. Alat Tulis");
        System.out.print("Pilih kategori: ");
        int pilihan = input.nextInt();

        if (pilihan == 1) {
            tampilkanMenuMakanan(menuMakanan);
        } else if (pilihan == 2) {
            tampilkanMenuAlatTulis(menuAlatTulis);
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    private static void tampilkanMenuMakanan(Makanan[] menu) {
        System.out.println("\n=== Menu Makanan ===");
        for (int i = 0; i < menu.length; i++) {
            menu[i].tampilkanInfo(i);
        }

        System.out.print("Pilih nomor makanan: ");
        int pilih = input.nextInt() - 1;
        if (pilih >= 0 && pilih < menu.length) {
            System.out.println("Anda membeli " + menu[pilih].getNama() + " seharga Rp" + menu[pilih].getHarga());
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    private static void tampilkanMenuAlatTulis(AlatTulis[] menu) {
        System.out.println("\n=== Menu Alat Tulis ===");
        for (int i = 0; i < menu.length; i++) {
            menu[i].tampilkanInfo(i);
        }

        System.out.print("Pilih nomor alat tulis: ");
        int pilih = input.nextInt() - 1;
        if (pilih >= 0 && pilih < menu.length) {
            System.out.println("Anda membeli " + menu[pilih].getNama() + " seharga Rp" + menu[pilih].getHarga());
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }
}
