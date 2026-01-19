import javax.swing.*;
import java.awt.*;

public class ProfileMahasiswa extends JFrame {

    public ProfileMahasiswa(String nim, String nama, String fakultas, String angkatan,
                            String prodi, String email, String noHp, String fotoPath) {

        setTitle("Profile Mahasiswa");
        setSize(500, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color bg = new Color(245, 247, 249);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(bg);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        mainPanel.setLayout(new BorderLayout(20, 20));

        // Panel untuk foto
        JPanel photoPanel = new JPanel();
        photoPanel.setBackground(bg);

        JLabel lblFoto;
        if (getClass().getResource(fotoPath) != null) {
            lblFoto = new JLabel(new ImageIcon(getClass().getResource(fotoPath)));
        } else {
            lblFoto = new JLabel("Foto Profil Tidak Ada");
        }
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        photoPanel.add(lblFoto);

        // Panel untuk informasi mahasiswa
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(bg);
        infoPanel.setLayout(new GridLayout(8, 2, 10, 10));

        infoPanel.add(new JLabel("NIM:"));
        infoPanel.add(new JLabel(nim));

        infoPanel.add(new JLabel("Nama:"));
        infoPanel.add(new JLabel(nama));

        infoPanel.add(new JLabel("Fakultas:"));
        infoPanel.add(new JLabel(fakultas));

        infoPanel.add(new JLabel("Angkatan:"));
        infoPanel.add(new JLabel(angkatan));

        infoPanel.add(new JLabel("Program Studi:"));
        infoPanel.add(new JLabel(prodi));

        infoPanel.add(new JLabel("Email:"));
        infoPanel.add(new JLabel(email));

        infoPanel.add(new JLabel("No HP:"));
        infoPanel.add(new JLabel(noHp));

        // Tombol Kembali ke Dashboard
        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBackground(new Color(34, 139, 34));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFocusPainted(false);
        btnKembali.addActionListener(e -> {
            dispose();
            new Dashboard(nama, nim); // kembali ke Dashboard
        });

        mainPanel.add(photoPanel, BorderLayout.NORTH);
        mainPanel.add(infoPanel, BorderLayout.CENTER);
        mainPanel.add(btnKembali, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}
