package Model;

public abstract class Mahasiswa implements Comparable<Mahasiswa> {
    private String nim;
    private String nama;
    private String email;
    private int umur;

    public Mahasiswa(String nim, String nama, String email, int umur) {
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.umur = umur;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public int getUmur() { return umur; }

    public void setnim(String nim) { this.nim = nim; }
    public void setNama(String nama) { this.nama = nama; }
    public void setEmail(String email) { this.email = email; }
    public void setUmur(int umur) { this.umur = umur; }
}
