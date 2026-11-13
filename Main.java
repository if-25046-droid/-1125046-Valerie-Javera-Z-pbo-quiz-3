import Controller.HealthyFoodController;
import Model.Customizable;
import View.MahasiswaDataView;

// Tahap 4: Interaksi CLI — Menu Utama & Aksi (Iterasi 1: Mahasiswa)
// Buatlah class utama ( Main.java ) yang menginisialisasi instance MahasiswaDataView dan menampilkan
// alur menu interaktif berbasis CLI secara berulang hingga pengguna memilih keluar.
// Alur Interaksi CLI, selalu berulang ya seperti biasa
// 1. Menu Utama (Pilih Entitas):
// === PILIH MENU ===
// 1. Mаhаsiswа
// 2. Sub-Menu (Pilih Aksi): Setelah entitas dipilih, tampilkan daftar aksi berikut dan hubungkan ke
// method pada DataView<T> :
// === PILIH AKSI ===
// 1. Tampilkan semua data
// 2. Cari satu data
// 3. Tambah data
// 4. Ubah data
// 5. Delete data
public class Main {
    public static void main(String[] args) {
        MahasiswaDataView view = new MahasiswaDataView();
        HealthyFoodController controller = new HealthyFoodController(view);
        controller.jalankan();
    }
    
    
}
