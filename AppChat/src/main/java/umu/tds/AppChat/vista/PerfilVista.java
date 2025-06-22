package umu.tds.AppChat.vista;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Calendar;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import umu.tds.AppChat.controller.PerfilController;
import umu.tds.AppChat.vista.observer.PerfilEvent;
import umu.tds.AppChat.vista.observer.PerfilListener;
import java.awt.FlowLayout;

public class PerfilVista {

	private JFrame frmEditarPerfil;
	private JTextField textField_nombre;
	private JTextField textField_email;
	private JDateChooser dateChooser;
	
	private PerfilController controller;
	
	private PerfilListener listener;

	/**
	 * Create the application.
	 */
	public PerfilVista(PerfilController controller, PerfilListener listener) {
		this.controller = controller;
		this.listener = listener;
		initialize();
	}
	
	public void showWindow() {
		frmEditarPerfil.setLocationRelativeTo(null);
		frmEditarPerfil.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditarPerfil = new JFrame();
		frmEditarPerfil.setTitle("Editar Perfil");
		frmEditarPerfil.setBounds(100, 100, 500, 300);
		frmEditarPerfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmEditarPerfil.getContentPane().add(panel, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(8, 8, 8, 8));
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JLabel lblPFP = new JLabel("");
		lblPFP.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_3.add(lblPFP);
		ImageIcon pfp = new ImageIcon(getClass().getResource("/images/usuario.png"));
		lblPFP.setIcon(new ImageIcon(pfp.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		
		JButton btnNewButton_2 = new JButton("Subir Foto");
		btnNewButton_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_3.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		frmEditarPerfil.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btn_aceptar = new JButton("Aceptar");
		panel_1.add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("Cancelar");
		panel_1.add(btn_cancelar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(12, 12, 12, 12));
		frmEditarPerfil.getContentPane().add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_nombre = new JTextField();
		GridBagConstraints gbc_textField_nombre = new GridBagConstraints();
		gbc_textField_nombre.insets = new Insets(0, 0, 5, 0);
		gbc_textField_nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_nombre.gridx = 1;
		gbc_textField_nombre.gridy = 0;
		panel_2.add(textField_nombre, gbc_textField_nombre);
		textField_nombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_email = new JTextField();
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.insets = new Insets(0, 0, 5, 0);
		gbc_textField_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_email.gridx = 1;
		gbc_textField_email.gridy = 1;
		panel_2.add(textField_email, gbc_textField_email);
		textField_email.setColumns(10);
		
		JLabel lbl_fecha = new JLabel("Fecha nacimiento");
		GridBagConstraints gbc_lbl_fecha = new GridBagConstraints();
		gbc_lbl_fecha.anchor = GridBagConstraints.EAST;
		gbc_lbl_fecha.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_fecha.gridx = 0;
		gbc_lbl_fecha.gridy = 2;
		panel_2.add(lbl_fecha, gbc_lbl_fecha);
		
		dateChooser = new JDateChooser();
		dateChooser.setDate(Calendar.getInstance().getTime());
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 2;
		panel_2.add(dateChooser, gbc_dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("Premium");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 4;
		panel_2.add(panel_4, gbc_panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("Precio Ajustado");
		panel_4.add(lblNewLabel_4);
		
		JButton btn_premium = new JButton(Double.toString(controller.getPrecioPremium()));
		if(controller.comprobarPremium()) btn_premium.setEnabled(false);
		panel_4.add(btn_premium);
		
		addManejadorAceptar(btn_aceptar);
		addManejadorCancelar(btn_cancelar);
		addManejadorPremium(btn_premium);
	}
	
	private void addManejadorAceptar(JButton btn_aceptar) {
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actualizar(textField_nombre.getText(), textField_email.getText(),
						dateChooser.getDate().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate());
				listener.updatePerfil(new PerfilEvent(this, textField_nombre.getText()));
				frmEditarPerfil.dispose();
			}
		});
	}
	
	private void addManejadorCancelar(JButton btn_cancelar) {
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEditarPerfil.dispose();
			}
		});
	}
	
	private void addManejadorPremium(JButton btn_premium) {
		btn_premium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.hacerPremium();
				JOptionPane.showMessageDialog(btn_premium, "¡Felicidades! ¡Ahora eres Premium!");
				btn_premium.setEnabled(false);
			}
		});
	}

}
