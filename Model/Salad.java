package Model;

import java.util.ArrayList;
import java.util.List;

public class Salad extends ProdukMakanan implements Customizable, BisaDipesan {
    private final List<String> topping = new ArrayList<>();

    public Salad(String id, String nama, double harga, int stok) {
        super(id, nama, harga, stok);
    }

    @Override
    public void tambahTopping(String namaTopping) {
        topping.add(namaTopping);
    }

    @Override
    public void hapusTopping(String namaTopping) {
        topping.remove(namaTopping);
    }

    @Override
    public void pesan() {
        System.out.println("Salad " + getNama() + " dipilih untuk dipesan.");
    }

    @Override
    public double hitungHarga() {
        return getHarga() + (topping.size() * 2000);
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("[Salad] " + getId() + " - " + getNama()
                + " | Harga dasar: Rp" + getHarga()
                + " | Stok: " + getStok()
                + " | Topping: " + (topping.isEmpty() ? "Tidak ada" : topping));
    }
}
