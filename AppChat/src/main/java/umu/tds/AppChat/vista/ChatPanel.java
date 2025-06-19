package umu.tds.AppChat.vista;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.List;
import umu.tds.AppChat.controller.ChatController;

public class ChatPanel extends JPanel {

    private JTextField textField;
    private JPanel panel_chats;
    private final ChatController controller;
    private final String contactoNombre;
    private final String contactoTLF;

    public ChatPanel(ChatController controller, String contactoNombre, String contactoTLF) {
        this.controller = controller;
        this.contactoNombre = contactoNombre;
        this.contactoTLF = contactoTLF;
        initialize();
        cargarMensajes();
    }

    private void initialize() {
        setLayout(new BorderLayout());

        // Panel superior con info del contacto
        JPanel panel_contacto = new JPanel(new BorderLayout());
        panel_contacto.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 2, true), new EmptyBorder(4, 4, 4, 4)));
        add(panel_contacto, BorderLayout.NORTH);

        JLabel lbl_iconocontacto = new JLabel("[Icono]");
        panel_contacto.add(lbl_iconocontacto, BorderLayout.WEST);

        JLabel lbl_nombre = new JLabel(contactoNombre);
        panel_contacto.add(lbl_nombre, BorderLayout.CENTER);

        JLabel lbl_telefono = new JLabel(contactoTLF);
        panel_contacto.add(lbl_telefono, BorderLayout.EAST);

        // Panel inferior para escribir
        JPanel panel_escribir = new JPanel(new BorderLayout());
        panel_escribir.setBackground(Color.DARK_GRAY);
        panel_escribir.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 2, true), new EmptyBorder(4, 4, 4, 4)));
        add(panel_escribir, BorderLayout.SOUTH);

        textField = new JTextField();
        panel_escribir.add(textField, BorderLayout.CENTER);
        textField.setColumns(10);

        JButton btnEnviar = new JButton("Enviar");
        panel_escribir.add(btnEnviar, BorderLayout.EAST);

        // Panel central para mostrar mensajes
        panel_chats = new JPanel();
        panel_chats.setLayout(new BoxLayout(panel_chats, BoxLayout.Y_AXIS));
        panel_chats.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(panel_chats);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        btnEnviar.addActionListener(e -> {
            String texto = textField.getText().trim();
            if (!texto.isEmpty()) {
                // controller.enviarMensajeActual(contactoNombre, texto);
                agregarMensaje(texto, true);
                textField.setText("");
            }
        });
    }

    private void cargarMensajes() {
        List<String> mensajes = controller.getMensajesCon(contactoTLF);
        mensajes.forEach(m -> agregarMensaje(m, true));
    }

    public void agregarMensaje(String texto, boolean esEmisor) {
        JPanel mensajePanel = new JPanel(new BorderLayout());
        mensajePanel.setBackground(new Color(255, 255, 255));
        mensajePanel.setBorder(new EmptyBorder(5, 10, 5, 10));

        JLabel mensajeLabel = new JLabel(texto);
        mensajeLabel.setOpaque(true);
        mensajeLabel.setBorder(new LineBorder(Color.GRAY, 1, true));
        mensajeLabel.setBackground(esEmisor ? new Color(220, 248, 198) : Color.LIGHT_GRAY);

        if (esEmisor) {
            mensajePanel.add(mensajeLabel, BorderLayout.EAST);
        } else {
            mensajePanel.add(mensajeLabel, BorderLayout.WEST);
        }

        panel_chats.add(mensajePanel);
        panel_chats.revalidate();
        panel_chats.repaint();
        SwingUtilities.invokeLater(() -> getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum()));
    }

    private JScrollBar getVerticalScrollBar() {
        JScrollPane scrollPane = (JScrollPane) getComponent(2);
        return scrollPane.getVerticalScrollBar();
    }
}