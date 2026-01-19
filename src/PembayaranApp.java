
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PembayaranApp {

    public static List<List<String>> semuaTransaksi = new ArrayList<>();
    public PembayaranApp(String namaDashboard, String nimDashboard) {

        JFrame frame = new JFrame("Pembayaran");
        // Warna
        Color bgColor = new Color(220, 245, 220);
        Color titleColor = new Color(0, 100, 60);
        Color btnColor = new Color(0, 170, 90);

        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setLayout(new GridLayout(12, 1, 12, 12)); // Tambah 1 baris untuk tombol Kembali

        JLabel title = new JLabel("FORM PEMBAYARAN", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(titleColor);

        JLabel lblNama = new JLabel("Nama");
        JTextField tfNama = new JTextField(namaDashboard);
        tfNama.setEditable(false);

        JLabel lblMahasiswa = new JLabel("Mahasiswa (NIM)");
        JTextField tfMahasiswa = new JTextField(nimDashboard);
        tfMahasiswa.setEditable(false);

        JLabel lblBank = new JLabel("Pilih Bank");
        lblBank.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        String[] bankList = {"-- Pilih Bank --", "BCA", "BRI", "BNI", "MANDIRI", "BTN"};
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

        JButton btnKembali = new JButton("KEMBALI");
        btnKembali.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnKembali.setBackground(Color.RED);
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFocusPainted(false);


        panel.add(title);
        panel.add(lblNama);
        panel.add(tfNama);
        panel.add(lblMahasiswa);
        panel.add(tfMahasiswa);
        panel.add(lblBank);
        panel.add(cbBank);
        panel.add(lblJumlah);
        panel.add(tfJumlah);
        panel.add(btnBayar);
        panel.add(lblHasil);
        panel.add(btnKembali);


        btnBayar.addActionListener(e -> {
            String nama = tfNama.getText();
            String bank = cbBank.getSelectedItem().toString();
            String jumlah = tfJumlah.getText();

            if (nama.isEmpty() || jumlah.isEmpty() || bank.equals("-- Pilih Bank --")) {
                JOptionPane.showMessageDialog(
                        frame, "Data tidak boleh kosong!",
                        "Warning", JOptionPane.WARNING_MESSAGE
                );
            } else {

                String kodeBayar = "PAY-" + System.currentTimeMillis();


                String tanggal = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                List<String> transaksi = List.of(tanggal, "UKT", "Rp " + jumlah, bank, kodeBayar);
                semuaTransaksi.add(transaksi);

                JOptionPane.showMessageDialog(
                        frame,
                        "Pembayaran berhasil!\nKode Pembayaran: " + kodeBayar,
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE
                );

                frame.dispose();


                new RiwayatTransaksi(nama, nimDashboard);
            }
        });


        btnKembali.addActionListener(e -> {
            frame.dispose();
            new Dashboard(namaDashboard, nimDashboard);
        });

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
