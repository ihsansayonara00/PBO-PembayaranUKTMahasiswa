import java.time.LocalDateTime;

public class Transaksi {
    private int jumlahBayar;
    private LocalDateTime waktu;

    public Transaksi(int jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
        this.waktu = LocalDateTime.now();
    }

    public int getJumlahBayar() {
        return jumlahBayar;
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }

    @Override
    public String toString() {
        return "Pembayaran Rp " + jumlahBayar + " | " + waktu;
    }
}
