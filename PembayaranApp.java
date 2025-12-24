import javax.swing.*;
import java.awt.*;

public class PembayaranApp {

    private boolean sudahBayar = false;
    private String kodeBayar = "";

    public PembayaranApp(String nim) {

        JFrame frame = new JFrame("Pembayaran UKT");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setLayout(new GridLayout(12, 1, 10, 10));

        JLabel title = new JLabel("FORM PEMBAYARAN", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel lblNim = new JLabel("NIM : " + nim);

        JLabel lblNama = new JLabel("Nama");
        JTextField tfNama = new JTextField();

        JLabel lblBank = new JLabel("Pilih Bank");
        JComboBox<String> cbBank = new JComboBox<>(new String[]{
                "-- Pilih Bank --", "BCA", "BRI", "BNI", "MANDIRI", "BTN"
        });

        JLabel lblJumlah = new JLabel("Jumlah Bayar");
        JTextField tfJumlah = new JTextField();

        JButton btnBayar = new JButton("GENERATE KODE BAYAR");
        JButton btnKonfirmasi = new JButton("KONFIRMASI PEMBAYARAN");
        btnKonfirmasi.setEnabled(false); // awalnya mati

        JLabel lblInfo = new JLabel(" ", SwingConstants.CENTER);
        lblInfo.setFont(new Font("Segoe UI", Font.BOLD, 13));

        panel.add(title);
        panel.add(lblNim);
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
            String jumlah = tfJumlah.getText();

            if (nama.isEmpty() || jumlah.isEmpty() || bank.equals("-- Pilih Bank --")) {
                JOptionPane.showMessageDialog(frame, "Lengkapi data terlebih dahulu!");
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
            sudahBayar = true;

            lblInfo.setText(
                    "<html>✔ PEMBAYARAN SELESAI<br>" +
                            "NIM : " + nim + "<br>" +
                            "Nama : " + tfNama.getText() + "<br>" +
                            "Bank : " + cbBank.getSelectedItem() + "<br>" +
                            "Jumlah : Rp " + tfJumlah.getText() + "<br>" +
                            "Kode Bayar : " + kodeBayar +
                            "</html>"
            );

            btnKonfirmasi.setEnabled(false);
        });

        frame.add(panel);
        frame.setSize(450, 520);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
