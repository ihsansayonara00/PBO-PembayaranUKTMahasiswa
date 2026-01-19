import javax.swing.*;
import java.awt.*;

public class Login extends JFrame { // pewarisan


        public Login() {
            //Kita sudah tidak lagi memaki jframe di sini
            setTitle("Login");
            setSize(450, 420);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel title = new JLabel("LOGIN APLIKASI", SwingConstants.CENTER);
            title.setFont(new Font("Segoe UI", Font.BOLD, 20));

            JLabel lblNim = new JLabel("NIM Mahasiswa");
            JTextField tfNim = new JTextField();

            JLabel lblPass = new JLabel("Password");
            JPasswordField pfPass = new JPasswordField();

            JButton btnLogin = new JButton("LOGIN");
            btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
            //menambahkan warna di tombobl login



            btnLogin.setBackground(new Color(52, 152, 219)); // biru
            btnLogin.setForeground(Color.WHITE);           // teks putih
            btnLogin.setFocusPainted(false);

            JPanel panel = new JPanel();
            panel.setBackground(new Color(204, 255, 204)); // hijau muda
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



                if (nim.equals("300") && pass.equals("2026")) {
                    JOptionPane.showMessageDialog(this, "Login berhasil!");
                    dispose();
                    new Dashboard("Septian ihsandi", nim);
                } else if (!nim.equals(nimBenar)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "NIM Mahasiswa tidak terdaftar!",
                            "Login Gagal",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau password salah!");
                }
            });
            add(panel);
            setVisible(true);

        }
    }







