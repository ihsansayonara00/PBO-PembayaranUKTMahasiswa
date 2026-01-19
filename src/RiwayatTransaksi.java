import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RiwayatTransaksi extends JFrame {

    private List<List<String>> riwayat = new ArrayList<>();

    public RiwayatTransaksi(String nama, String nim) {

        setTitle("Riwayat Transaksi");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        riwayat.add(List.of("10-01-2026", "UKT", "Rp 7.500.000", "BNI"));

        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel header = new JLabel(
                "<html><b>Nama:</b> " + nama +
                        "<br><b>NIM:</b> " + nim +
                        "<br><br><b>Riwayat Pembayaran</b></html>"
        );
        header.setFont(new Font("Segoe UI", Font.PLAIN, 14));





        // ---- Ubah: buat JTable untuk menampilkan riwayat transaksi ----
        String[] columnNames = {"Tanggal", "Jenis", "Jumlah", "Bank"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // ---- Ubah: tambahkan data dari riwayat ke tabel ----
        for (List<String> t : riwayat) {
            tableModel.addRow(t.toArray());
        }

        JTable table = new JTable(tableModel);
        table.setEnabled(false); // agar tidak bisa diedit
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(table);

        // Tombol Kembali
        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBackground(new Color(34, 139, 34));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFocusPainted(false);
        btnKembali.addActionListener(e -> {
            dispose();
            new Dashboard(nama, nim);
        });

        panel.add(header, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER); // ---- Ubah: tambahkan JTable di tengah ----
        panel.add(btnKembali, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
