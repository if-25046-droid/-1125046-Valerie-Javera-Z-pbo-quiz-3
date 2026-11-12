package View;

import java.util.Scanner;
import Model.ProdukMakanan;

public class HealthyFoodView {
    private final Scanner scanner = new Scanner(System.in);

    public void tampilkanMenuUtama() {
        System.out.println("\n===== HEALTHY FOOD =====");
        System.out.println("1. Lihat daftar produk");
        System.out.println("2. Pesan produk");
        System.out.println("3. Lihat keranjang");
        System.out.println("4. Cetak struk dan checkout");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    public int inputInt(String pesan) {
        System.out.print(pesan);
        while (!scanner.hasNextInt()) {
            System.out.print("Masukkan angka yang benar: ");
            scanner.next();
        }
        int nilai = scanner.nextInt();
        scanner.nextLine();
        return nilai;
    }

    public String inputString(String pesan) {
        System.out.print(pesan);
        return scanner.nextLine();
    }

    public void tampilkanProduk(Iterable<ProdukMakanan> daftar) {
        System.out.println("\n--- DAFTAR PRODUK ---");
        for (ProdukMakanan produk : daftar) {
            produk.tampilkanDetail();
        }
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}
