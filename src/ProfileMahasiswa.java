import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ProfileMahasiswa extends JFrame {

    public ProfileMahasiswa(String nim, String nama, String fakultas, String angkatan,
                            String prodi, String email, String noHp, String fotoPath) {

        setTitle("Profile Mahasiswa");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // warna background utama
        Color bg = new Color(245, 247, 249);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(bg);
        mainPanel.setLayout(new BorderLayout());

        // ---------------- HEADER ----------------
        JPanel header = new JPanel();
        header.setBackground(new Color(52, 152, 219));
        header.setPreferredSize(new Dimension(0, 180));
        header.setLayout(null); // absolute positioning untuk foto

        // Foto profil
        JLabel lblFoto;
        ImageIcon icon;
        if (getClass().getResource(fotoPath) != null) {
            icon = new ImageIcon(getClass().getResource(fotoPath));
            // resize gambar agar bulat
            Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
        } else {
            icon = new ImageIcon();
        }

        lblFoto = new JLabel(icon);
        lblFoto.setBounds(180, 30, 120, 120);
        lblFoto.setBorder(new LineBorder(Color.WHITE, 4));
        lblFoto.setOpaque(true);
        lblFoto.setBackground(Color.WHITE);
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        lblFoto.setVerticalAlignment(SwingConstants.CENTER);
        lblFoto.setHorizontalTextPosition(JLabel.CENTER);
        lblFoto.setVerticalTextPosition(JLabel.BOTTOM);

        // Nama di header
        JLabel lblNama = new JLabel(nama, SwingConstants.CENTER);
        lblNama.setForeground(Color.WHITE);
        lblNama.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNama.setBounds(0, 150, 500, 30);

        header.add(lblFoto);
        header.add(lblNama);

        // ---------------- INFO PANEL ----------------
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(bg);
        infoPanel.setLayout(new GridLayout(7, 1, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        infoPanel.add(createInfoCard("NIM", nim));
        infoPanel.add(createInfoCard("Fakultas", fakultas));
        infoPanel.add(createInfoCard("Angkatan", angkatan));
        infoPanel.add(createInfoCard("Program Studi", prodi));
        infoPanel.add(createInfoCard("Email", email));
        infoPanel.add(createInfoCard("No HP", noHp));

        // Tombol Kembali
        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBackground(new Color(34, 139, 34));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFocusPainted(false);
        btnKembali.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnKembali.addActionListener(e -> {
            dispose();
            new Dashboard(nama, nim);
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(bg);
        btnPanel.add(btnKembali);

        // ---------------- ADD MAIN PANEL ----------------
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(infoPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    // ---------------- METODE BANTU ----------------
    private JPanel createInfoCard(String label, String value) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        JLabel lblLabel = new JLabel(label + ":");
        lblLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblLabel.setForeground(new Color(52, 73, 94));

        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblValue.setForeground(new Color(44, 62, 80));

        panel.add(lblLabel, BorderLayout.WEST);
        panel.add(lblValue, BorderLayout.CENTER);

        return panel;
    }
}
