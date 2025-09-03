package PBOPRAKTEK2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Daftar menu makanan
        Makanan[] menuMakanan = {
            new Makanan("Nasi Goreng", 15000),
            new Makanan("Mie Goreng", 20000),
            new Makanan("Ayam Geprek", 25000)
        };

        // Daftar menu alat tulis
        Alattulis[] menuAlattulis = {
            new Alattulis("Bolpoin", 5000),
            new Alattulis("Pensil", 3000),
            new Alattulis("Buku Tulis", 10000)
        };

        System.out.println("=== Selamat Datang di Koperasi Keluarga Sehat ===");
        System.out.println("1. Makanan");
        System.out.println("2. Alat Tulis");
        System.out.print("Pilih kategori: ");
        int kategori = sc.nextInt();

        if (kategori == 1) {
            System.out.println("\n--- Menu Makanan ---");
            for (int i = 0; i < menuMakanan.length; i++) {
                menuMakanan[i].tampilkanInfo(i);
            }

            System.out.print("Pilih nomor makanan: ");
            int pilihan = sc.nextInt();
            System.out.print("Jumlah beli: ");
            int jumlah = sc.nextInt();

            Makanan beli = menuMakanan[pilihan-1];
            double total = beli.getHarga() * jumlah;

            System.out.println("\n=== Struk Pembelian ===");
            System.out.println(beli.getNama() + " x" + jumlah + " = Rp" + total);

        } else if (kategori == 2) {
            System.out.println("\n--- Menu Alat Tulis ---");
            for (int i = 0; i < menuAlattulis.length; i++) {
                menuAlattulis[i].tampilkanInfo(i);
            }

            System.out.print("Pilih nomor alat tulis: ");
            int pilihan = sc.nextInt();
            System.out.print("Jumlah beli: ");
            int jumlah = sc.nextInt();

            Alattulis beli = menuAlattulis[pilihan-1];
            double total = beli.getHarga() * jumlah;

            System.out.println("\n=== Struk Pembelian ===");
            System.out.println(beli.getNama() + " x" + jumlah + " = Rp" + total);

        } else {
            System.out.println("Pilihan tidak valid!");
        }

        sc.close();
    }
}
