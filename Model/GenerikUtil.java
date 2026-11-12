package Model;

import java.util.List;

public class GenerikUtil {
    // Generic method: menerima tipe data apa pun.
    public static <T> void tampilkanData(T data) {
        System.out.println("Data: " + data);
    }

    // Bounded type: T harus ProdukMakanan atau turunannya.
    public static <T extends ProdukMakanan> void tampilkanDetailProduk(List<T> daftar) {
        for (T produk : daftar) {
            produk.tampilkanDetail();
        }
    }

    // Unbounded wildcard: menerima List dengan tipe elemen apa pun.
    public static void tampilkanSemuaTipe(List<?> daftar) {
        for (Object data : daftar) {
            System.out.println(data);
        }
    }

    // Upper bounded wildcard: menerima ProdukMakanan atau subclass-nya.
    public static void tampilkanProduk(List<? extends ProdukMakanan> daftar) {
        for (ProdukMakanan produk : daftar) {
            produk.tampilkanDetail();
        }
    }

    // Lower bounded wildcard: dapat menerima RiceBowl, ProdukMakanan, atau Object.
    public static void tambahkanRiceBowl(List<? super RiceBowl> daftar, RiceBowl produk) {
        daftar.add(produk);
    }
}
