import javax.swing.*;
import java.awt.*;

public class PembayaranApp {

    public PembayaranApp() {

        JFrame frame = new JFrame("Pembayaran");

        JLabel title = new JLabel("FORM PEMBAYARAN", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel lblNama = new JLabel("Nama");
        JTextField tfNama = new JTextField();

        JLabel lblJumlah = new JLabel("Jumlah Bayar");
        JTextField tfJumlah = new JTextField();

        JButton btnBayar = new JButton("BAYAR");
        btnBayar.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JLabel lblHasil = new JLabel(" ", SwingConstants.CENTER);
        lblHasil.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JFrame jFrame= new JFrame("Pembayaran");

        // Warna
        Color bgColor = new Color(0, 206, 209);
        Color titleColor = new Color(0, 0, 0);
        Color btnColor = new Color(255, 250, 205);
        Color btnText = Color.WHITE;

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setLayout(new GridLayout(7, 1, 10, 10));

        JLabel Title = new JLabel("FORM PEMBAYARAN", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(titleColor);

        // Komponen input
        JLabel LblNama = new JLabel("Nama");
        JTextField Tfnama= new JTextField();

        JLabel LblJumlah = new JLabel("Jumlah Bayar");
        JTextField TfJumlah = new JTextField();
        JButton BtnBayar = new JButton("BAYAR");
        btnBayar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBayar.setBackground(btnColor);
        btnBayar.setForeground(btnText);
        btnBayar.setFocusPainted(false);

        // Hasil
        JLabel LblHasil = new JLabel(" ", SwingConstants.CENTER);
        lblHasil.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblHasil.setForeground(new Color(0, 120, 60));

        // Styling label
        lblNama.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblJumlah.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        panel.add(title);
        panel.add(lblNama);
        panel.add(tfNama);
        panel.add(lblJumlah);
        panel.add(tfJumlah);
        panel.add(btnBayar);
        panel.add(lblHasil);

        btnBayar.addActionListener(e -> {
            String nama = tfNama.getText();
            String jumlah = tfJumlah.getText();

            if (nama.isEmpty() || jumlah.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Data tidak boleh kosong!");
            } else {
                lblHasil.setText("✔ " + nama + " membayar Rp " + jumlah);
            }
        });

        frame.add(panel);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
