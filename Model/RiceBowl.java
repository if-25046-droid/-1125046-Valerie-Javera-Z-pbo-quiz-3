package Model;

import java.util.ArrayList;
import java.util.List;

public class RiceBowl extends ProdukMakanan
        implements Customizable, BisaDipesan, MenuMarker {
    private final List<String> topping = new ArrayList<>();

    public RiceBowl(String id, String nama, double harga, int stok) {
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

    public List<String> getTopping() {
        return new ArrayList<>(topping);
    }

    @Override
    public void pesan() {
        System.out.println("Rice bowl " + getNama() + " dipilih untuk dipesan.");
    }

    @Override
    public double hitungHarga() {
        return getHarga() + (topping.size() * 3000);
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("[Rice Bowl] " + getId() + " - " + getNama()
                + " | Harga dasar: Rp" + getHarga()
                + " | Stok: " + getStok()
                + " | Topping: " + (topping.isEmpty() ? "Tidak ada" : topping));
    }
}
