package Model;

public class Sandwich extends ProdukMakanan implements BisaDibatalkan {
    public Sandwich(String id, String nama, double harga, int stok) {
        super(id, nama, harga, stok);
    }

    @Override
    public void pesan() {
        System.out.println("Sandwich " + getNama() + " dipilih untuk dipesan.");
    }

    @Override
    public void batalkan() {
        System.out.println("Pesanan sandwich " + getNama() + " dibatalkan.");
    }

    @Override
    public double hitungHarga() {
        return getHarga();
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("[Sandwich] " + getId() + " - " + getNama()
                + " | Harga: Rp" + getHarga()
                + " | Stok: " + getStok());
    }
}
