package View;

import java.util.Scanner;
import Model.*;

// Tahap 4: Interaksi CLI — Menu Utama & Aksi (Iterasi 1: Mahasiswa)
// Buatlah class utama ( Main.java ) yang menginisialisasi instance MahasiswaDataView dan menampilkan
// alur menu interaktif berbasis CLI secara berulang hingga pengguna memilih keluar.
// Alur Interaksi CLI, selalu berulang ya seperti biasa
// 1. Menu Utama (Pilih Entitas):
// === PILIH MENU ===
// 1. Mаhаsiswа
// 2. Sub-Menu (Pilih Aksi): Setelah entitas dipilih, tampilkan daftar aksi berikut dan hubungkan ke
// method pada DataView<T> :
// === PILIH AKSI ===
// 1. Tampilkan semua data
// 2. Cari satu data
// 3. Tambah data
// 4. Ubah data
// 5. Delete data
public class MahasiswaDataView extends DataView<Mahasiswa> {
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

    @Override
    protected String getPrimaryKeyValue(Mahasiswa data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrimaryKeyValue'");
    }

    @Override
    protected String[] getFields() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFields'");
    }

    @Override
    protected Mahasiswa convertValuesToModel(String[] values) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertValuesToModel'");
    }

    @Override
    protected String[] convertModelToValues(Mahasiswa data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertModelToValues'");
    }
}
