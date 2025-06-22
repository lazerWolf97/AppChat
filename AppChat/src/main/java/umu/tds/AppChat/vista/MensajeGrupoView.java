package umu.tds.AppChat.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import umu.tds.AppChat.controller.MensajeGrupoController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class MensajeGrupoView {

	private JFrame frmEnviarMensajeA;
	private JTextArea textArea;
	
	private MensajeGrupoController controller;

	public MensajeGrupoView(MensajeGrupoController controller) {
		this.controller = controller;
		initialize();
	}
	
	public void showWindow() {
		frmEnviarMensajeA.setLocationRelativeTo(null);
		frmEnviarMensajeA.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnviarMensajeA = new JFrame();
		frmEnviarMensajeA.setTitle("Enviar mensaje a Grupo");
		frmEnviarMensajeA.setBounds(100, 100, 450, 300);
		frmEnviarMensajeA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmEnviarMensajeA.getContentPane().add(panel, BorderLayout.WEST);
		
		JLabel lbl_icon = new JLabel("");
		ImageIcon pfp = new ImageIcon(getClass().getResource("/images/enviar.png"));
		lbl_icon.setIcon(new ImageIcon(pfp.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
		panel.add(lbl_icon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(12, 12, 12, 12));
		frmEnviarMensajeA.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(3, 3, 3, 3));
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Enviar mensaje");
		panel_3.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lbl_grupo = new JLabel(controller.getNombreGrupo());
		panel_3.add(lbl_grupo, BorderLayout.EAST);
		
		textArea = new JTextArea();
		panel_1.add(textArea, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		frmEnviarMensajeA.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btn_enviar = new JButton("Enviar");
		panel_2.add(btn_enviar);
		
		JButton btn_cancelar = new JButton("Salir");
		panel_2.add(btn_cancelar);
		
		addManejadorCancelar(btn_cancelar);
		addManejadorEnviar(btn_enviar);
	}
	
	private void addManejadorCancelar(JButton btn_cancelar) {
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEnviarMensajeA.dispose();
			}
		});
	}
	
	private void addManejadorEnviar(JButton btn_enviar) {
		btn_enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.enviarMensaje(textArea.getText());
			}
		});
	}

}
