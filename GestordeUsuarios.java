import javax.swing.*;
import java.awt.*;

public class GestordeUsuarios extends JFrame {
            public GestordeUsuarios(){
                setTitle("Gestor de usuarios");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(900,600);
                setLocationRelativeTo(null);
                setLayout(new BorderLayout(10,10));

                //Header
                JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel headerLabel = new JLabel("Gestor de usuario");
                headerLabel.setFont(new Font("Arial",Font.BOLD,18));
                headerLabel.setIcon(UIManager.getIcon("FileView.computerIcon"));
                headerPanel.add(headerLabel);
                add(headerPanel, BorderLayout.NORTH);

                // WEST: Navegación
                JPanel navPanel = new JPanel(new GridLayout(5, 1, 0, 5));
                String[] botones = {"Dashboard", "Usuarios", "Informes", "Ajustes", "Ayuda"};
                for (String txt : botones) {
                    JButton b = new JButton(txt);
                    b.setFont(new Font("Arial", Font.PLAIN, 14));
                    navPanel.add(b);
                }
                navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                add(navPanel, BorderLayout.WEST);

                // CENTER: Formulario (GridBagLayout)
                JPanel formPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);
                gbc.anchor = GridBagConstraints.WEST;
                gbc.fill = GridBagConstraints.HORIZONTAL;

                // Nombre
                gbc.gridx = 0; gbc.gridy = 0;
                formPanel.add(new JLabel("Nombre:"), gbc);
                gbc.gridx = 1; gbc.weightx = 1.0;
                JTextField nombreField = new JTextField(20);
                formPanel.add(nombreField, gbc);

                // Email
                gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
                formPanel.add(new JLabel("Email:"), gbc);
                gbc.gridx = 1; gbc.weightx = 1.0;
                JTextField emailField = new JTextField(20);
                formPanel.add(emailField, gbc);

                // Rol
                gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
                formPanel.add(new JLabel("Rol:"), gbc);
                gbc.gridx = 1; gbc.weightx = 1.0;
                JComboBox<String> rolCombo = new JComboBox<>(new String[]{"Admin", "Editor", "Invitado"});
                formPanel.add(rolCombo, gbc);

                // Activo
                gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
                formPanel.add(new JLabel("Activo:"), gbc);
                gbc.gridx = 1;
                JCheckBox activoCheck = new JCheckBox();
                activoCheck.setSelected(true);
                formPanel.add(activoCheck, gbc);

                // Notas
                gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0; gbc.anchor = GridBagConstraints.NORTHWEST;
                formPanel.add(new JLabel("Notas:"), gbc);
                gbc.gridx = 1; gbc.weightx = 1.0; gbc.weighty = 1.0;
                gbc.fill = GridBagConstraints.BOTH;
                JTextArea notasArea = new JTextArea(4, 20);
                JScrollPane notasScroll = new JScrollPane(notasArea);
                formPanel.add(notasScroll, gbc);

                add(formPanel, BorderLayout.CENTER);

                // EAST: Previsualización (JTabbedPane)
                JPanel previewPanel = new JPanel(new BorderLayout());
                previewPanel.setPreferredSize(new Dimension(260, 400));
                JTabbedPane tabbedPane = new JTabbedPane();
                JTextArea resumenArea = new JTextArea("Aquí se mostrará el resumen...");
                resumenArea.setEditable(false);
                tabbedPane.addTab("Resumen", new JScrollPane(resumenArea));
                JTextArea logsArea = new JTextArea("Logs del sistema...");
                logsArea.setEditable(false);
                tabbedPane.addTab("Logs", new JScrollPane(logsArea));
                previewPanel.add(tabbedPane, BorderLayout.CENTER);
                add(previewPanel, BorderLayout.EAST);

                // SOUTH: Botonera
                JPanel buttonBar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
                JButton btnCancelar = new JButton("Cancelar");
                JButton btnLimpiar = new JButton("Limpiar");
                JButton btnGuardar = new JButton("Guardar");
                getRootPane().setDefaultButton(btnGuardar);
                buttonBar.add(btnCancelar);
                buttonBar.add(btnLimpiar);
                buttonBar.add(btnGuardar);
                add(buttonBar, BorderLayout.SOUTH);
                getRootPane().setDefaultButton(btnGuardar);
                // Evento del botón Guardar
                btnGuardar.addActionListener(e -> {
                    DialogConfirmacion dialog = new DialogConfirmacion(this);
                    dialog.setVisible(true); // modal
                });

                buttonBar.add(btnCancelar);
                buttonBar.add(btnLimpiar);
                buttonBar.add(btnGuardar);
                add(buttonBar, BorderLayout.SOUTH);
            }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new GestordeUsuarios().setVisible(true);
            });
    }
}
