public class Mahasiswa {
    private String nim;
    private String nama;
    private TagihanUKT tagihan;

    public Mahasiswa(String nim, String nama, TagihanUKT tagihan) {
        this.nim = nim;
        this.nama = nama;
        this.tagihan = tagihan;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public TagihanUKT getTagihan() {
        return tagihan;
    }
}
