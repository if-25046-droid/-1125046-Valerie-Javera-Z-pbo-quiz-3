package Model;

public interface Repository<T> {
    void tambah(T data);
    T cari(String id) throws ProdukTidakDitemukanException;
    void tampilkanSemua();
}
