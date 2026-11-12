package Model;

public interface Customizable {
    void tambahTopping(String topping);
    void hapusTopping(String topping);

    default void tampilkanInfoKustomisasi() {
        System.out.println(formatInfo("Produk ini mendukung kustomisasi topping."));
    }

    static void infoRestoran() {
        System.out.println("Healthy Food - Makanan sehat, pilihan tepat!");
    }

    private String formatInfo(String pesan) {
        return "[Info] " + pesan;
    }
}
