import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Set Look and Feel modern (Nimbus)
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        // Jalankan login
        SwingUtilities.invokeLater(() -> new Login());
    }
}
