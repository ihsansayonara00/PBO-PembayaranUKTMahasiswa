import javax.swing.*;
import java.awt.*;

public class PembayaranApp {

    public static void main(String[] args) {

        // Frame utama
        JFrame frame = new JFrame("Aplikasi Pembayaran Desktop");

        // Komponen
        JLabel lblNama = new JLabel("Nama:");
        JTextField tfNama = new JTextField(15);

        JLabel lblJumlah = new JLabel("Jumlah Bayar:");
        JTextField tfJumlah = new JTextField(15);

        JButton btnBayar = new JButton("Bayar");

        JLabel lblHasil = new JLabel(" ");

        // Panel
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(lblNama);
        panel.add(tfNama);

        panel.add(lblJumlah);
        panel.add(tfJumlah);

        panel.add(new JLabel());
        panel.add(btnBayar);

        panel.add(new JLabel("Hasil:"));
        panel.add(lblHasil);
            String nama = tfNama.getText();
            String jumlah = tfJumlah.getText();

            if (nama.isEmpty() || jumlah.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Data tidak boleh kosong!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                lblHasil.setText("Nama: " + nama + " | Bayar: Rp " + jumlah);
            }
        });

        // Setting frame
        frame.add(panel);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
