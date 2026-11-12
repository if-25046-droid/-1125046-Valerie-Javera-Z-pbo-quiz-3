package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.*;
import View.HealthyFoodView;

public class HealthyFoodController {
    private final HealthyFoodView view;
    private final MenuManager menu = new MenuManager();
    private final Keranjang<ProdukMakanan> keranjang = new Keranjang<>();

    public HealthyFoodController(HealthyFoodView view) {
        this.view = view;
        isiMenuAwal();
    }

    private void isiMenuAwal() {
        menu.tambah(new RiceBowl("RB01", "Chicken Teriyaki Bowl", 25000, 10));
        menu.tambah(new Salad("SD01", "Fresh Fruit Salad", 18000, 8));
        menu.tambah(new Sandwich("SW01", "Chicken Sandwich", 20000, 6));
    }

    public void jalankan() {
        boolean berjalan = true;
        while (berjalan) {
            view.tampilkanMenuUtama();
            int pilihan = view.inputInt("");

            switch (pilihan) {
                case 1:
                    tampilkanProdukTerurut();
                    break;
                case 2:
                    prosesPemesanan();
                    break;
                case 3:
                    keranjang.tampilkanItem();
                    break;
                case 4:
                    checkout();
                    break;
                case 0:
                    berjalan = false;
                    view.tampilkanPesan("Terima kasih telah menggunakan Healthy Food.");
                    break;
                default:
                    view.tampilkanPesan("Pilihan tidak tersedia.");
            }
        }
    }

    private void tampilkanProdukTerurut() {
        List<ProdukMakanan> daftar = menu.getDaftarProduk();
        Collections.sort(daftar); // Comparable: urut berdasarkan harga.
        view.tampilkanProduk(daftar);
    }

    private void prosesPemesanan() {
        try {
            String id = view.inputString("Masukkan ID produk: ");
            ProdukMakanan produk = menu.cari(id);

            int jumlah = view.inputInt("Jumlah pesanan: ");
            produk.kurangiStok(jumlah);

            if (produk instanceof BisaDipesan) {
                ((BisaDipesan) produk).pesan();
            }

            if (produk instanceof Customizable) {
                String topping = view.inputString(
                    "Masukkan topping (kosongkan jika tidak ada): "
                );
                if (!topping.trim().isEmpty()) {
                    ((Customizable) produk).tambahTopping(topping);
                }
                ((Customizable) produk).tampilkanInfoKustomisasi();
            }

            if (produk instanceof MenuMarker) {
                view.tampilkanPesan("Produk ini memiliki penanda MenuMarker.");
            }

            keranjang.tambahItem(produk);
            view.tampilkanPesan("Produk berhasil dimasukkan ke keranjang.");
        } catch (ProdukTidakDitemukanException | StokTidakCukupException e) {
            view.tampilkanPesan("Gagal memesan: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            view.tampilkanPesan("Input tidak valid: " + e.getMessage());
        } finally {
            view.tampilkanPesan("Proses pemesanan selesai.");
        }
    }

    private void checkout() {
        if (keranjang.isEmpty()) {
            view.tampilkanPesan("Keranjang masih kosong.");
            return;
        }

        double total = 0;
        System.out.println("\n===== RINCIAN PEMBAYARAN =====");
        for (ProdukMakanan produk : keranjang.getItems()) {
            produk.tampilkanDetail();
            total += produk.hitungTotal(1);
        }

        String promo = view.inputString("Kode promo (HEALTHY10 / kosong): ");
        if (!promo.trim().isEmpty() && "HEALTHY10".equalsIgnoreCase(promo)) {
            total *= 0.90;
        }

        final double totalAkhir = total;
        Printable struk = () -> {
            System.out.println("\n===== STRUK HEALTHY FOOD =====");
            System.out.println("Jumlah jenis item: " + keranjang.getItems().size());
            System.out.println("Total pembayaran: Rp" + totalAkhir);
            System.out.println("Terima kasih!");
        };
        struk.cetak();

        keranjang.kosongkan();
    }

    // Contoh pemanggilan generic interface dan generic method.
    public void contohPenggunaanGeneric() {
        Repository<ProdukMakanan> repository = menu;
        repository.tampilkanSemua();

        GenerikUtil.tampilkanData("Healthy Food");
        GenerikUtil.tampilkanDetailProduk(menu.getDaftarProduk());

        List<String> teks = new ArrayList<>();
        teks.add("Contoh unbounded wildcard");
        GenerikUtil.tampilkanSemuaTipe(teks);

        GenerikUtil.tampilkanProduk(menu.getDaftarProduk());

        List<Object> campuran = new ArrayList<>();
        GenerikUtil.tambahkanRiceBowl(campuran,
                new RiceBowl("RB99", "Contoh Rice Bowl", 22000, 5));

        Pasangan<String, ProdukMakanan> pasangan =
                new Pasangan<>("RB01", menu.getDaftarProduk().get(0));
        GenerikUtil.tampilkanData(pasangan);
    }

    public void contohInterfaceInheritance() {
        try {
            ProdukMakanan produk = menu.cari("SW01");
            if (produk instanceof BisaDibatalkan) {
                BisaDibatalkan pesanan = (BisaDibatalkan) produk;
                pesanan.pesan();    // Method dari interface induk.
                pesanan.batalkan(); // Method dari interface turunan.
            }
        } catch (ProdukTidakDitemukanException e) {
            view.tampilkanPesan(e.getMessage());
        }
    }
}
