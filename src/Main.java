import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Transaksi> riwayat = new ArrayList<>();

    public static void main(String[] args) {
        TagihanUKT tagihan = new TagihanUKT(3500000);
        Mahasiswa mhs = new Mahasiswa("22001", "Andi", tagihan);

        int pilihan;
        do {
            System.out.println("\n=== SISTEM PEMBAYARAN UKT ===");
            System.out.println("Mahasiswa : " + mhs.getNama());
            System.out.println("1. Bayar UKT");
            System.out.println("2. Riwayat Transaksi");
            System.out.println("3. Info Tagihan");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    bayarUKT(mhs);
                    break;
                case 2:
                    tampilkanRiwayat();
                    break;
                case 3:
                    infoTagihan(mhs);
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    static void bayarUKT(Mahasiswa mhs) {
        TagihanUKT tagihan = mhs.getTagihan();

        if (tagihan.isLunas()) {
            System.out.println("UKT sudah LUNAS ✔");
            return;
        }

        System.out.println("Sisa Tagihan: Rp " + tagihan.getTotalTagihan());
        System.out.print("Jumlah Bayar: Rp ");
        int bayar = input.nextInt();

        tagihan.bayar(bayar);
        riwayat.add(new Transaksi(bayar));

        System.out.println("Pembayaran berhasil.");
    }

    static void tampilkanRiwayat() {
        System.out.println("\n=== RIWAYAT TRANSAKSI ===");
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (Transaksi t : riwayat) {
                System.out.println(t);
            }
        }
    }

    static void infoTagihan(Mahasiswa mhs) {
        TagihanUKT tagihan = mhs.getTagihan();
        if (tagihan.isLunas()) {
            System.out.println("Status: LUNAS ✔");
        } else {
            System.out.println("Sisa Tagihan: Rp " + tagihan.getTotalTagihan());
        }
    }
}
