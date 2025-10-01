import javax.swing.*;
import java.awt.*;

public class DialogConfirmacion extends JDialog {
    private JPanel Panel;

    public DialogConfirmacion(JFrame parent) {
        super(parent, "Confirmación", true); // true = modal
        setLayout(new BorderLayout(10, 10));

        // Mensaje central
        JPanel Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel mensaje = new JLabel("¿Guardar cambios?");
        mensaje.setFont(new Font("Arial", Font.PLAIN, 14));
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        add(mensaje, BorderLayout.CENTER);

        // Botonera inferior
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnAceptar);
        add(buttonPanel, BorderLayout.SOUTH);

        // Cierre básico
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(parent);

        // 🚧 De momento sin lógica adicional
        btnAceptar.addActionListener(e -> dispose());
        btnCancelar.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GestordeUsuarios().setVisible(true);
        });
    }
}
