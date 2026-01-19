import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private JButton createSidebarButton(String text, String iconPath) {
        JButton button = new JButton(text);

        // Set icon dari folder resources jika ada
        if (getClass().getResource(iconPath) != null) {
            button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        }

        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(10);

        button.setFocusPainted(false);
        button.setBackground(Color.WHITE);

        return button;
    }

    public Dashboard(String nama, String nim) {
        setTitle("Dashboard Mahasiswa");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color green = new Color(34, 139, 34);
        Color bg = new Color(245, 247, 249);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(bg);

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBackground(Color.WHITE);
        sidebar.setLayout(new GridLayout(7, 1, 10, 10));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Membuat tombol dengan ikon (sesuaikan path ikon di folder /icons)
        JButton btnDashboard = createSidebarButton("Dashboard", "/icons/dashboard.png.png");
        JButton btnTagihan = createSidebarButton("Tagihan UKT", "/icons/Tagihan.png.png");
        JButton btnBayar = createSidebarButton("Pembayaran", "/icons/Pembayaran.png.png");
        JButton btnRiwayat = createSidebarButton("Riwayat", "/icons/Riwayat.png.png");
        JButton btnLogout = createSidebarButton("Logout", "/icons/Logout.png.png");

        btnLogout.setForeground(Color.RED);

        sidebar.add(btnDashboard);
        sidebar.add(btnTagihan);
        sidebar.add(btnBayar);
        sidebar.add(btnRiwayat);
        sidebar.add(new JLabel());
        sidebar.add(btnLogout);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(green);
        header.setPreferredSize(new Dimension(0, 100));
        header.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel lblWelcome = new JLabel(
                "<html><b>Selamat Datang,</b><br>" + nama +
                        "<br><small>NIM: " + nim + "</small></html>"
        );
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        header.add(lblWelcome, BorderLayout.WEST);

        JPanel content = new JPanel();
        content.setBackground(bg);
        content.setLayout(new GridLayout(2, 1, 15, 15));
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel cardStatus = new JPanel(new GridLayout(3, 2, 10, 10));
        cardStatus.setBackground(Color.WHITE);
        cardStatus.setBorder(BorderFactory.createTitledBorder("Status Pembayaran"));

        cardStatus.add(new JLabel("Total Tagihan"));
        cardStatus.add(new JLabel("Rp 7.500.000"));

        cardStatus.add(new JLabel("Status"));
        cardStatus.add(new JLabel("Belum Bayar"));

        cardStatus.add(new JLabel("Batas Pembayaran"));
        cardStatus.add(new JLabel("15 Februari 2026"));

        JPanel cardInfo = new JPanel(new GridLayout(3, 2, 10, 10));
        cardInfo.setBackground(Color.WHITE);
        cardInfo.setBorder(BorderFactory.createTitledBorder("Informasi Mahasiswa"));

        cardInfo.add(new JLabel("Nama"));
        cardInfo.add(new JLabel(nama));

        cardInfo.add(new JLabel("Fakultas"));
        cardInfo.add(new JLabel("Fakultas Teknik"));

        cardInfo.add(new JLabel("Program Studi"));
        cardInfo.add(new JLabel("Teknik Informatika"));

        content.add(cardStatus);
        content.add(cardInfo);

        // Action Listener untuk tombol
        btnDashboard.addActionListener(e -> {

            JOptionPane.showMessageDialog(this, "Anda sudah di Dashboard.");
        });

        btnTagihan.addActionListener(e -> {
            dispose();
            new TagihanUkt(nama, nim);
        });

        btnBayar.addActionListener(e -> {
            dispose();
            new PembayaranApp(nama, nim);
        });

        btnRiwayat.addActionListener(e -> {
            dispose();
            new RiwayatTransaksi(nama, nim);
        });

        btnLogout.addActionListener(e -> {
            dispose();
            new Login();
        });

        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(content, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }
}
