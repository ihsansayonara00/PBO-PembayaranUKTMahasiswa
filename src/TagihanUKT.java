public class TagihanUKT {
    private int totalTagihan;

    public TagihanUKT(int totalTagihan) {
        this.totalTagihan = totalTagihan;
    }

    public int getTotalTagihan() {
        return totalTagihan;
    }

    public boolean isLunas() {
        return totalTagihan == 0;
    }

    public void bayar(int jumlah) {
        if (jumlah >= totalTagihan) {
            totalTagihan = 0;
        } else {
            totalTagihan -= jumlah;
        }
    }
}
