import javax.swing.*;
import java.awt.*;

public class LoginApp {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        JFrame frame = new JFrame("Login");

        JLabel title = new JLabel("LOGIN APLIKASI", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel lblNim = new JLabel("NIM");
        JTextField tfNim = new JTextField();

        JLabel lblUser = new JLabel("Username");
        JTextField tfUser = new JTextField();

        JLabel lblPass = new JLabel("Password");
        JPasswordField pfPass = new JPasswordField();

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setLayout(new GridLayout(8, 1, 10, 10));

        panel.add(title);
        panel.add(lblNim);
        panel.add(tfNim);
        panel.add(lblUser);
        panel.add(tfUser);
        panel.add(lblPass);
        panel.add(pfPass);
        panel.add(btnLogin);

        btnLogin.addActionListener(e -> {
            String nim  = tfNim.getText();
            String user = tfUser.getText();
            String pass = new String(pfPass.getPassword());

            if (nim.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "NIM tidak boleh kosong!");
                return;
            }

            if (user.equals("mahasiswa") && pass.equals("123456")) {
                JOptionPane.showMessageDialog(frame, "Login berhasil!");
                frame.dispose();
                new PembayaranApp(nim); // ⬅ kirim NIM
            } else {
                JOptionPane.showMessageDialog(frame, "Username atau password salah!");
            }
        });

        frame.add(panel);
        frame.setSize(450, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
