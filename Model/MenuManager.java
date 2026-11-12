package Model;

import java.util.ArrayList;
import java.util.List;

public class MenuManager implements Repository<ProdukMakanan> {
    private final List<ProdukMakanan> daftarProduk = new ArrayList<>();

    @Override
    public void tambah(ProdukMakanan data) {
        daftarProduk.add(data);
    }

    @Override
    public ProdukMakanan cari(String id) throws ProdukTidakDitemukanException {
        for (ProdukMakanan produk : daftarProduk) {
            if (produk.getId().equalsIgnoreCase(id)) {
                return produk;
            }
        }
        throw new ProdukTidakDitemukanException(
            "Produk dengan ID " + id + " tidak ditemukan."
        );
    }

    @Override
    public void tampilkanSemua() {
        for (ProdukMakanan produk : daftarProduk) {
            produk.tampilkanDetail();
        }
    }

    public List<ProdukMakanan> getDaftarProduk() {
        return new ArrayList<>(daftarProduk);
    }
}
