import javax.swing.*;
import java.awt.*;

public class Dashboard {

    public Dashboard(String nama, String nim) {

        JFrame frame = new JFrame("Dashboard Mahasiswa");
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // WARNA
        Color green = new Color(34, 139, 34);
        Color bg = new Color(245, 247, 249);

        // MAIN PANEL
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(bg);

        // SIDEBAR
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBackground(Color.WHITE);
        sidebar.setLayout(new GridLayout(6, 1, 10, 10));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JButton btnDashboard = new JButton("Dashboard");
        JButton btnTagihan = new JButton("Tagihan UKT");
        JButton btnBayar = new JButton("Pembayaran");
        JButton btnRiwayat = new JButton("Riwayat");
        JButton btnLogout = new JButton("Logout");

        btnLogout.setForeground(Color.RED);

        sidebar.add(btnDashboard);
        sidebar.add(btnTagihan);
        sidebar.add(btnBayar);
        sidebar.add(btnRiwayat);
        sidebar.add(new JLabel());
        sidebar.add(btnLogout);

        // HEADER
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

        // CONTENT
        JPanel content = new JPanel();
        content.setBackground(bg);
        content.setLayout(new GridLayout(2, 1, 15, 15));
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // CARD STATUS PEMBAYARAN
        JPanel cardStatus = new JPanel(new GridLayout(3, 2, 10, 10));
        cardStatus.setBackground(Color.WHITE);
        cardStatus.setBorder(BorderFactory.createTitledBorder("Status Pembayaran"));

        cardStatus.add(new JLabel("Total Tagihan"));
        cardStatus.add(new JLabel("Rp 7.500.000"));

        cardStatus.add(new JLabel("Status"));
        cardStatus.add(new JLabel("Belum Bayar"));

        cardStatus.add(new JLabel("Batas Pembayaran"));
        cardStatus.add(new JLabel("15 Februari 2026"));

        // iNFORMASI MAHASISWA
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


        btnBayar.addActionListener(e -> {
            frame.dispose();
            new PembayaranApp(nama, nim);
        });

        btnLogout.addActionListener(e -> {
            frame.dispose();
            new Login();
        });

        // ADD
        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(content, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
