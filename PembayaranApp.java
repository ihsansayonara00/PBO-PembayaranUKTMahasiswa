import javax.swing.*;
import java.awt.*;

public class PembayaranApp {

    private final int TAGIHAN_UKT = 5000000;

    private String kodeBayar = "";

    public PembayaranApp(String nim) {

        JFrame frame = new JFrame("Pembayaran UKT");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setLayout(new GridLayout(13, 1, 10, 10));

        JLabel title = new JLabel("FORM PEMBAYARAN UKT", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel lblNim = new JLabel("NIM : " + nim);

        JLabel lblTagihan = new JLabel("Tagihan UKT : Rp " + TAGIHAN_UKT);
        lblTagihan.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JLabel lblNama = new JLabel("Nama");
        JTextField tfNama = new JTextField();

        JLabel lblBank = new JLabel("Pilih Bank");
        JComboBox<String> cbBank = new JComboBox<>(new String[]{
                "-- Pilih Bank --", "BCA", "BRI", "BNI", "Mandiri", "BTN"
        });

        JLabel lblJumlah = new JLabel("Jumlah Bayar");
        JTextField tfJumlah = new JTextField();

        JButton btnBayar = new JButton("GENERATE KODE BAYAR");
        JButton btnKonfirmasi = new JButton("KONFIRMASI PEMBAYARAN");
        btnKonfirmasi.setEnabled(false);

        JLabel lblInfo = new JLabel(" ", SwingConstants.CENTER);
        lblInfo.setFont(new Font("Segoe UI", Font.BOLD, 13));

        panel.add(title);
        panel.add(lblNim);
        panel.add(lblTagihan);
        panel.add(lblNama);
        panel.add(tfNama);
        panel.add(lblBank);
        panel.add(cbBank);
        panel.add(lblJumlah);
        panel.add(tfJumlah);
        panel.add(btnBayar);
        panel.add(btnKonfirmasi);
        panel.add(lblInfo);

        btnBayar.addActionListener(e -> {
            String nama = tfNama.getText();
            String bank = cbBank.getSelectedItem().toString();
            String jumlahText = tfJumlah.getText();

            if (nama.isEmpty() || jumlahText.isEmpty() || bank.equals("-- Pilih Bank --")) {
                JOptionPane.showMessageDialog(frame, "Lengkapi data terlebih dahulu!");
                return;
            }
            int jumlahBayar;
            try {
                jumlahBayar = Integer.parseInt(jumlahText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Jumlah harus berupa angka!");
                return;
            }
            if (jumlahBayar < TAGIHAN_UKT) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Jumlah bayar kurang dari tagihan!\nTagihan: Rp " + TAGIHAN_UKT
                );
                return;
            }
            kodeBayar = bank.substring(0, 3).toUpperCase()
                    + "-" + (int) (Math.random() * 9000 + 1000);
            lblInfo.setText(
                    "<html>KODE PEMBAYARAN:<br><b>" + kodeBayar +
                            "</b><br>Status: MENUNGGU PEMBAYARAN</html>"
            );
            btnKonfirmasi.setEnabled(true);
        });
        btnKonfirmasi.addActionListener(e -> {
            frame.dispose();
            new BuktiPembayaranApp(
                    nim,
                    tfNama.getText(),
                    cbBank.getSelectedItem().toString(),
                    tfJumlah.getText(),
                    String.valueOf(TAGIHAN_UKT),
                    kodeBayar
            );
        });

        frame.add(panel);
        frame.setSize(470, 560);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
