import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RiwayatTransaksi {

    private String nama;
    private String nim;

    public RiwayatTransaksi(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("Riwayat Transaksi");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Riwayat Transaksi Mahasiswa", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);


        String[] columns = {"No", "Tanggal", "Jumlah Bayar", "Bank", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);


        model.addRow(new Object[]{1, "2026-01-01", "Rp 2.500.000", "BCA", "Lunas"});
        model.addRow(new Object[]{2, "2026-02-01", "Rp 2.500.000", "Mandiri", "Lunas"});
        model.addRow(new Object[]{3, "2026-03-01", "Rp 2.500.000", "BNI", "Belum Bayar"});

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);


        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBackground(new Color(52, 152, 219));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFocusPainted(false);
        btnKembali.addActionListener(e -> {
            frame.dispose();
            new Dashboard(nama, nim);
        });

        panel.add(btnKembali, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
