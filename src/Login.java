import javax.swing.*;
import java.awt.*;

public class Login {


        public Login() {
            JFrame frame = new JFrame("Login");

            JLabel title = new JLabel("LOGIN APLIKASI", SwingConstants.CENTER);
            title.setFont(new Font("Segoe UI", Font.BOLD, 20));

            JLabel lblNim = new JLabel("NIM Mahasiswa");
            JTextField tfNim = new JTextField();

            JLabel lblPass = new JLabel("Password");
            JPasswordField pfPass = new JPasswordField();

            JButton btnLogin = new JButton("LOGIN");
            btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
            //menambahkan warna di tombobl login
            btnLogin.setBackground(new Color(0, 170, 90)); // hijau
            btnLogin.setForeground(Color.WHITE);           // teks putih
            btnLogin.setFocusPainted(false);

            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
            panel.setLayout(new GridLayout(6, 1, 10, 10));

            panel.add(title);
            panel.add(lblNim);
            panel.add(tfNim);
            panel.add(lblPass);
            panel.add(pfPass);
            panel.add(btnLogin);

            btnLogin.addActionListener(e -> {
                String nim = tfNim.getText();
                String pass = new String(pfPass.getPassword());

                String nimBenar = "300";
                String passBenar = "2026";


                if (nim.equals(nimBenar) && pass.equals(passBenar)) {
                    JOptionPane.showMessageDialog(frame, "Login berhasil!");
                    frame.dispose();
                    new PembayaranApp();
                } else if (!nim.equals(nimBenar)) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "NIM Mahasiswa tidak terdaftar!",
                            "Login Gagal",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(frame, "Username atau password salah!");
                }
            });

            frame.add(panel);
            frame.setSize(450, 420);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }







