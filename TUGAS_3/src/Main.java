import id.ac.polban.model.AlatTulis;
import id.ac.polban.model.Makanan;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menu
        Makanan[] menuMakanan = {
            new Makanan("Nasi Goreng", 15000),
            new Makanan("Mie Goreng", 12000)
        };

        AlatTulis[] menuAlatTulis = {
            new AlatTulis("Bolpoin", 5000),
            new AlatTulis("Pensil", 3000)
        };

        System.out.println("---- SELAMAT DATANG DI KOPERASI ----");
        System.out.println("1. Makanan");
        System.out.println("2. Alat Tulis");
        System.out.print("Pilih kategori = ");
        int kategori = input.nextInt();

        String namaBarang = "";
        double harga = 0;
        int jumlah = 0;

        if (kategori == 1) {
            System.out.println("=== Menu Makanan ===");
            for (int i = 0; i < menuMakanan.length; i++) {
                menuMakanan[i].tampilkanInfo(i);
            }
            System.out.print("Pilih nomor makanan: ");
            int pilih = input.nextInt() - 1;

            if (pilih >= 0 && pilih < menuMakanan.length) {
                namaBarang = menuMakanan[pilih].getNama();
                harga = menuMakanan[pilih].getHarga();
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                jumlah = input.nextInt();
            }
        } else if (kategori == 2) {
            System.out.println("=== Menu Alat Tulis ===");
            for (int i = 0; i < menuAlatTulis.length; i++) {
                menuAlatTulis[i].tampilkanInfo(i);
            }
            System.out.print("Pilih nomor alat tulis: ");
            int pilih = input.nextInt() - 1;

            if (pilih >= 0 && pilih < menuAlatTulis.length) {
                namaBarang = menuAlatTulis[pilih].getNama();
                harga = menuAlatTulis[pilih].getHarga();
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                jumlah = input.nextInt();
            }
        }

        // STRUK
        if (jumlah > 0) {
            double total = harga * jumlah;
            System.out.println("\n=== STRUK PEMBELIAN ===");
            System.out.println("Barang   : " + namaBarang);
            System.out.println("Harga    : Rp " + harga);
            System.out.println("Jumlah   : " + jumlah);
            System.out.println("Total    : Rp " + total);
            System.out.println("========================");
        } else {
            System.out.println("Tidak ada barang yang dibeli.");
        }

        input.close();
    }
}
