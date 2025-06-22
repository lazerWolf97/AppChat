package umu.tds.AppChat.vista;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class MensajePanel extends JPanel {

	private JLabel lbl_emisor;
	private JLabel lbl_receptor;
	private JLabel lbl_texto;
	
	private String emisor;
	private String receptor;
	private String mensaje;
	LocalDateTime fechahora;
	
	private DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("[dd/MM/yyyy] HH:mm");
	private JLabel lbl_fechahora;

	public MensajePanel(String mensaje, String emisor, String receptor, LocalDateTime fechahora) {
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
		this.fechahora = fechahora;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new LineBorder(new Color(0, 0, 0), 2, true)));
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		lbl_emisor = new JLabel(emisor);
		panel.add(lbl_emisor, BorderLayout.WEST);
		
		lbl_receptor = new JLabel(receptor);
		panel.add(lbl_receptor, BorderLayout.EAST);
		
		lbl_fechahora = new JLabel(fechahora.format(formatter));
		panel.add(lbl_fechahora, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Texto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5))));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		lbl_texto = new JLabel(mensaje);
		scrollPane.setViewportView(lbl_texto);
	}

}
