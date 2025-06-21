package umu.tds.AppChat.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ChatPreviewPanel extends JPanel {

	private String contacto;
	private String mensaje;
	private boolean isEmisor;
	private LocalDateTime fecha;
	
	private DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("[dd/MM/yyyy] HH:mm");
	
	public ChatPreviewPanel(String mensaje, String contacto, LocalDateTime fecha, boolean isEmisor) {
		this.contacto = contacto;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.isEmisor = isEmisor;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(new BorderLayout());
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		JLabel lbl_icon = new JLabel("New label");
		add(lbl_icon, BorderLayout.WEST);
		
		JLabel lbl_contacto = new JLabel(contacto);
		add(lbl_contacto, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(isEmisor ? new Color(220, 248, 198) : Color.LIGHT_GRAY);
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2, true), new EmptyBorder(5, 5, 5, 5)));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_mensaje = new JLabel(mensaje);
		panel.add(lbl_mensaje);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_fecha = new JLabel(fecha.format(formatter));
		panel_1.add(lbl_fecha, BorderLayout.WEST);
		
		JButton btn_abrirchat = new JButton("Abrir Chat");
		panel_1.add(btn_abrirchat, BorderLayout.EAST);
	}
	
	private void addManejadorAbrir(JButton btn_abrirchat) {
		btn_abrirchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

}
