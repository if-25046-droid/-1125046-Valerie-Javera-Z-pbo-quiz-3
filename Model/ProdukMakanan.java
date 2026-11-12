package Model;

public abstract class ProdukMakanan implements Comparable<ProdukMakanan> {
    private final String id;
    private final String nama;
    private final double harga;
    private int stok;

    public ProdukMakanan(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public abstract void tampilkanDetail();
    public abstract double hitungHarga();

    // Method overloading: nama sama, parameter berbeda.
    public double hitungTotal(int jumlah) {
        return hitungHarga() * jumlah;
    }

    public double hitungTotal(int jumlah, String kodePromo) {
        double total = hitungTotal(jumlah);
        if ("HEALTHY10".equalsIgnoreCase(kodePromo)) {
            total *= 0.90;
        }
        return total;
    }

    public double hitungTotal(int jumlah, Ukuran ukuran) {
        return (hitungHarga() + ukuran.getTambahanHarga()) * jumlah;
    }

    public void kurangiStok(int jumlah) throws StokTidakCukupException {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari nol.");
        }
        if (jumlah > stok) {
            throw new StokTidakCukupException(
                "Stok " + nama + " tidak cukup. Stok tersedia: " + stok
            );
        }
        stok -= jumlah;
    }

    @Override
    public int compareTo(ProdukMakanan produkLain) {
        return Double.compare(this.hitungHarga(), produkLain.hitungHarga());
    }
}
