HEALTHY FOOD - LATIHAN PBO JAVA (MVC)

Kebutuhan:
- Java JDK 8 atau lebih baru.
- Tidak membutuhkan library eksternal.

Struktur:
- Model   : class produk, enum, interface, generic, dan exception.
- View    : input dan tampilan console.
- Controller: alur program dan penghubung Model-View.
- Main.java: titik awal program.

Cara menjalankan:
1. Ekstrak ZIP.
2. Buka terminal pada folder HealthyFood_MVC.
3. Compile:
   javac Main.java Model/*.java View/*.java Controller/*.java
4. Jalankan:
   java Main

Contoh data:
- RB01 = Chicken Teriyaki Bowl
- SD01 = Fresh Fruit Salad
- SW01 = Chicken Sandwich

Kode promo:
- HEALTHY10 = diskon 10%

Materi yang dicontohkan:
- Abstract class dan inheritance
- Overriding dan overloading
- Enum
- Regular interface
- Generic interface
- Functional interface dan lambda
- Marker interface
- Interface inheritance
- Multiple interface
- default, static, dan private interface method
- Built-in Java interface Comparable
- Generic class
- Generic method
- Bounded type parameter
- Multiple type parameters
- Unbounded, extends, dan super wildcard
- Custom exception, throw, throws, try-catch-finally
- MVC

Catatan:
Contoh ini merupakan program latihan console sederhana. Keranjang menyimpan produk
yang dipesan; untuk menyederhanakan latihan, jumlah item yang sama tidak digabung
menjadi satu baris. Harga topping pada RiceBowl dan Salad dihitung dari jumlah
topping yang ditambahkan.
