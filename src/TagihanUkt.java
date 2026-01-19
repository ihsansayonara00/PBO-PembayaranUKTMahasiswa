import javax.swing.*;
import java.awt.*;

public class TagihanUkt extends JFrame {

    public TagihanUkt(String nama, String nim) {
        setTitle("Tagihan UKT");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color bg = new Color(245, 247, 249);
        JPanel panel = new JPanel();
        panel.setBackground(bg);
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel header = new JLabel("Tagihan UKT Mahasiswa", SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel lblNama = new JLabel("Nama: " + nama);
        lblNama.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JLabel lblNim = new JLabel("NIM: " + nim);
        lblNim.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JLabel lblJumlahTagihan = new JLabel("Total Tagihan: Rp 7.500.000");
        lblJumlahTagihan.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBackground(new Color(34, 139, 34));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFocusPainted(false);
        btnKembali.addActionListener(e -> {
            dispose();
            new Dashboard(nama, nim);
        });

        panel.add(header);
        panel.add(lblNama);
        panel.add(lblNim);
        panel.add(lblJumlahTagihan);
        panel.add(btnKembali);

        add(panel);
        setVisible(true);
    }
}
