import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RiwayatTransaksi extends JFrame {

    // contoh data riwayat (sementara)
    private List<String> riwayat = new ArrayList<>();

    public RiwayatTransaksi(String nama, String nim) {

        setTitle("Riwayat Transaksi");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // contoh isi riwayat
        riwayat.add("15-02-2026 | UKT | Rp 7.500.000 | BCA");

        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel header = new JLabel(
                "<html><b>Nama:</b> " + nama +
                        "<br><b>NIM:</b> " + nim +
                        "<br><br><b>Riwayat Pembayaran</b></html>"
        );
        header.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JTextArea area = new JTextArea();
        area.setEditable(false);

        if (riwayat.isEmpty()) {
            area.setText("Belum ada transaksi.");
        } else {
            for (String s : riwayat) {
                area.append(s + "\n");
            }
        }

        JButton btnKembali = new JButton("Kembali");
        btnKembali.addActionListener(e -> {
            dispose();
            new Dashboard(nama, nim);
        });

        panel.add(header, BorderLayout.NORTH);
        panel.add(new JScrollPane(area), BorderLayout.CENTER);
        panel.add(btnKembali, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
