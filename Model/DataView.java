package Model;

import java.util.ArrayList;
import java.util.List;

public class DataView<T> {
    private List<T> record;
}

    DataView(List<T> record) {
        this.record = record;
    }

   //Mencetak seluruh data di records berdasarkan header dari getFields() dan isi data dari convertModelToValues(T data).
    public static <T extends DataView<T>> void printAll(List<T> record) {
        
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
