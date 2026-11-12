package Model;

import java.util.ArrayList;
import java.util.List;

public class Keranjang<T> {
    private final List<T> items = new ArrayList<>();

    public void tambahItem(T item) {
        items.add(item);
    }

    public void hapusItem(T item) {
        items.remove(item);
    }

    public void tampilkanItem() {
        if (items.isEmpty()) {
            System.out.println("Keranjang masih kosong.");
            return;
        }
        for (T item : items) {
            System.out.println(item);
        }
    }

    public List<T> getItems() {
        return new ArrayList<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void kosongkan() {
        items.clear();
    }
}
