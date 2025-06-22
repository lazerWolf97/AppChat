package umu.tds.AppChat.vista;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import umu.tds.AppChat.controller.ChatController;
import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.exceptions.UserException;

public class ChatPanel extends JPanel {

    private JTextField textField;
    private JPanel panel_chats;
    private final ChatController controller;
    private final String contactoNombre;
    private final String contactoTLF;
    
    private DateTimeFormatter formatter = DateTimeFormatter
    			.ofPattern("[dd/MM/yyyy] HH:mm");

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
        
        JPanel panel = new JPanel();
        panel_contacto.add(panel, BorderLayout.EAST);
        
        JButton btn_exportar = new JButton("Exportar PDF");
        btn_exportar.setEnabled(controller.isPremium());
        btn_exportar.setVisible(controller.isPremium());
        panel.add(btn_exportar);
        
        JLabel lbl_telefono = new JLabel(contactoTLF);
        panel.add(lbl_telefono);

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
        	try {
        		String texto = textField.getText().trim();
        		if (!texto.isEmpty()) {
                	textField.setText("");
        		}
        	} catch (Exception exception) {
        		JOptionPane.showMessageDialog(btnEnviar, exception.getMessage());
        	}
        });
        
        btn_exportar.addActionListener(e -> {
        	controller.exportarPDF(contactoTLF);
        });
    }

    private void cargarMensajes() {
        List<Mensaje> mensajes = controller.getMensajesCon(contactoTLF);
        for(Mensaje m : mensajes) {
        	agregarMensaje(m.getTexto(), m.getFechaHora().format(formatter),
        			m.getEmisor().compararTLF(CurrentSession.getUsuarioActual()));
        	
        }
    }

    public void agregarMensaje(String texto, String fechahora, boolean esEmisor) {
        JPanel mensajePanel = new JPanel(new BorderLayout());
        mensajePanel.setBackground(new Color(255, 255, 255));
        mensajePanel.setBorder(new EmptyBorder(5, 10, 5, 10));

        // Panel interno con BoxLayout vertical (para fecha y mensaje)
        JPanel burbujaPanel = new JPanel();
        burbujaPanel.setLayout(new BoxLayout(burbujaPanel, BoxLayout.Y_AXIS));
        burbujaPanel.setOpaque(true);
        burbujaPanel.setBorder(new CompoundBorder(
            new LineBorder(Color.GRAY, 1, true),
            new EmptyBorder(5, 8, 5, 8)
        ));
        burbujaPanel.setBackground(esEmisor ? new Color(220, 248, 198) : Color.LIGHT_GRAY);

        // Label de fecha y hora
        JLabel fechaLabel = new JLabel(fechahora);
        fechaLabel.setFont(new Font("Roboto", Font.PLAIN, 10));
        fechaLabel.setForeground(Color.DARK_GRAY);
        fechaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Label del mensaje
        JLabel mensajeLabel = new JLabel(texto);
        mensajeLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
        mensajeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        burbujaPanel.add(fechaLabel);
        burbujaPanel.add(Box.createVerticalStrut(4));
        burbujaPanel.add(mensajeLabel);

        if (esEmisor) {
            mensajePanel.add(burbujaPanel, BorderLayout.EAST);
        } else {
            mensajePanel.add(burbujaPanel, BorderLayout.WEST);
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
    
    public String getTLFContacto() {
    	return contactoTLF;
    }
    
}