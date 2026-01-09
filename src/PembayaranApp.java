import javax.swing.*;
import java.awt.*;

public class PembayaranApp {

    public PembayaranApp() {

        JFrame frame = new JFrame("Pembayaran");
        //warna dari pembayaran di atas
        Color bgColor = new Color(220, 245, 220);
        Color titleColor = new Color(0, 100, 60);
        Color btnColor = new Color(0, 170, 90);

        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setLayout(new GridLayout(11, 1, 12, 12));

        JLabel title = new JLabel("FORM PEMBAYARAN", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(titleColor);

        JLabel lblNama = new JLabel("Nama");
        lblNama.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JTextField tfNama = new JTextField();

        JLabel lblMahasiswa = new JLabel("Mahasiswa (NIM)");
        JTextField tfMahasiswa = new JTextField();

        JLabel LblBank = new JLabel("Pilih Bank");
        LblBank.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        String[] bankList = {
                "-- Pilih Bank --",
                "BCA",
                "BRI",
                "BNI",
                "MANDIRI",
                "BTN"
        };

        JComboBox<String> cbBank = new JComboBox<>(bankList);

        JLabel lblJumlah = new JLabel("Jumlah Bayar");
        lblJumlah.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JTextField tfJumlah = new JTextField();

        JButton btnBayar = new JButton("BAYAR");
        btnBayar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBayar.setBackground(btnColor);
        btnBayar.setForeground(Color.WHITE);
        btnBayar.setFocusPainted(false);
        JLabel lblHasil = new JLabel(" ", SwingConstants.CENTER);
        lblHasil.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblHasil.setForeground(new Color(0, 120, 60));

        panel.add(title);
        panel.add(lblNama);
        panel.add(tfNama);
        panel.add(cbBank);
        panel.add(lblMahasiswa);
        panel.add(tfMahasiswa);
        panel.add(lblJumlah);
        panel.add(tfJumlah);
        panel.add(btnBayar);
        panel.add(lblHasil);

        btnBayar.addActionListener(e -> {
            String nama = tfNama.getText();
            String bank = cbBank.getSelectedItem().toString();
            String jumlah = tfJumlah.getText();

            if (nama.isEmpty() || jumlah.isEmpty () || bank.equals("pilih bank")) {
                JOptionPane.showMessageDialog(
                        frame, "Data tidak boleh kosong!",
                        "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                lblHasil.setText("✔ " + nama + " membayar Rp " + jumlah + "via" + bank);
            }
        });

        frame.add(panel);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
