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

        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel header = new JLabel(
                "<html><b>Nama:</b> " + nama +
                        "<br><b>NIM:</b> " + nim +
                        "<br><br><b>Riwayat Pembayaran</b></html>"
        );
        header.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        String[] columnNames = {"Tanggal", "Jenis", "Jumlah", "Bank", "Kode Bayar"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (List<String> t : PembayaranApp.semuaTransaksi) {
            tableModel.addRow(t.toArray());
        }

        String[] columns = {"Tanggal", "Jenis", "Jumlah", "Bank"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (List<String> t : riwayat) {
            tableModel.addRow(t.toArray());
        }

        JTable table = new JTable(tableModel);
        table.setEnabled(false); //
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(table);


        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBackground(new Color(34, 139, 34));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFocusPainted(false);
        btnKembali.addActionListener(e -> {
            dispose();
            new Dashboard(nama, nim);
        });

        panel.add(header, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnKembali, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
