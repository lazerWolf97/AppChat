package umu.tds.AppChat.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import umu.tds.AppChat.controller.SignupController;
import umu.tds.exceptions.UserException;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import java.awt.Component;
import javax.swing.ImageIcon;

public class SignupView {

	private JFrame frmAppchatSignup;
	private JTextField textField_telefono;
	private JTextField textField_nombre;
	
	private SignupController controller;
	private JTextField textField_email;
	private JPasswordField passwordField;
	private JPasswordField passwordField_confirmar;
	private JDateChooser date_fechan;
	
	private File imagenseleccionada;


	/**
	 * Create the application.
	 */
	public SignupView(SignupController controller) {
		this.controller = controller;
		initialize();
	}
	
	public void showWindow() {
		frmAppchatSignup.setLocationRelativeTo(null);
		frmAppchatSignup.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchatSignup = new JFrame();
		frmAppchatSignup.setResizable(false);
		frmAppchatSignup.setTitle("AppChat - Signup");
		frmAppchatSignup.setBounds(100, 100, 450, 450);
		frmAppchatSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchatSignup.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Signup", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmAppchatSignup.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_tlfnombre = new JPanel();
		panel.add(panel_tlfnombre, BorderLayout.NORTH);
		GridBagLayout gbl_panel_tlfnombre = new GridBagLayout();
		gbl_panel_tlfnombre.columnWidths = new int[]{0, 0, 0};
		gbl_panel_tlfnombre.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_tlfnombre.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_tlfnombre.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_tlfnombre.setLayout(gbl_panel_tlfnombre);
		
		JLabel lbl_telefono = new JLabel("Teléfono");
		lbl_telefono.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		GridBagConstraints gbc_lbl_telefono = new GridBagConstraints();
		gbc_lbl_telefono.anchor = GridBagConstraints.WEST;
		gbc_lbl_telefono.insets = new Insets(5, 5, 5, 5);
		gbc_lbl_telefono.gridx = 0;
		gbc_lbl_telefono.gridy = 0;
		panel_tlfnombre.add(lbl_telefono, gbc_lbl_telefono);
		
		textField_telefono = new JTextField();
		GridBagConstraints gbc_textField_telefono = new GridBagConstraints();
		gbc_textField_telefono.insets = new Insets(5, 5, 5, 5);
		gbc_textField_telefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_telefono.gridx = 1;
		gbc_textField_telefono.gridy = 0;
		panel_tlfnombre.add(textField_telefono, gbc_textField_telefono);
		textField_telefono.setColumns(10);
		
		JLabel lbl_nombre = new JLabel("Nombre Completo");
		lbl_nombre.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		GridBagConstraints gbc_lbl_nombre = new GridBagConstraints();
		gbc_lbl_nombre.insets = new Insets(5, 5, 5, 5);
		gbc_lbl_nombre.gridx = 0;
		gbc_lbl_nombre.gridy = 1;
		panel_tlfnombre.add(lbl_nombre, gbc_lbl_nombre);
		
		textField_nombre = new JTextField();
		GridBagConstraints gbc_textField_nombre = new GridBagConstraints();
		gbc_textField_nombre.insets = new Insets(5, 5, 5, 5);
		gbc_textField_nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_nombre.gridx = 1;
		gbc_textField_nombre.gridy = 1;
		panel_tlfnombre.add(textField_nombre, gbc_textField_nombre);
		textField_nombre.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_3.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lbl_password = new JLabel("Contraseña");
		lbl_password.setFont(new Font("Roboto Condensed", Font.PLAIN, 10));
		GridBagConstraints gbc_lbl_password = new GridBagConstraints();
		gbc_lbl_password.anchor = GridBagConstraints.EAST;
		gbc_lbl_password.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_password.gridx = 0;
		gbc_lbl_password.gridy = 0;
		panel_4.add(lbl_password, gbc_lbl_password);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 0;
		panel_4.add(passwordField, gbc_passwordField);
		
		JLabel lbl_confirmar = new JLabel("Confirmar Contraseña");
		lbl_confirmar.setFont(new Font("Roboto Condensed", Font.PLAIN, 10));
		GridBagConstraints gbc_lbl_confirmar = new GridBagConstraints();
		gbc_lbl_confirmar.anchor = GridBagConstraints.EAST;
		gbc_lbl_confirmar.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_confirmar.gridx = 0;
		gbc_lbl_confirmar.gridy = 1;
		panel_4.add(lbl_confirmar, gbc_lbl_confirmar);
		
		passwordField_confirmar = new JPasswordField();
		GridBagConstraints gbc_passwordField_confirmar = new GridBagConstraints();
		gbc_passwordField_confirmar.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_confirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_confirmar.gridx = 1;
		gbc_passwordField_confirmar.gridy = 1;
		panel_4.add(passwordField_confirmar, gbc_passwordField_confirmar);
		
		JLabel lbl_fechan = new JLabel("Fecha de Nacimiento");
		lbl_fechan.setFont(new Font("Roboto Condensed", Font.PLAIN, 10));
		GridBagConstraints gbc_lbl_fechan = new GridBagConstraints();
		gbc_lbl_fechan.anchor = GridBagConstraints.EAST;
		gbc_lbl_fechan.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_fechan.gridx = 0;
		gbc_lbl_fechan.gridy = 2;
		panel_4.add(lbl_fechan, gbc_lbl_fechan);
		
		date_fechan = new JDateChooser();
		GridBagConstraints gbc_date_fechan = new GridBagConstraints();
		gbc_date_fechan.insets = new Insets(0, 0, 5, 0);
		gbc_date_fechan.fill = GridBagConstraints.BOTH;
		gbc_date_fechan.gridx = 1;
		gbc_date_fechan.gridy = 2;
		panel_4.add(date_fechan, gbc_date_fechan);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Roboto Condensed", Font.PLAIN, 10));
		GridBagConstraints gbc_lbl_email = new GridBagConstraints();
		gbc_lbl_email.anchor = GridBagConstraints.EAST;
		gbc_lbl_email.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_email.gridx = 0;
		gbc_lbl_email.gridy = 3;
		panel_4.add(lbl_email, gbc_lbl_email);
		
		textField_email = new JTextField();
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.insets = new Insets(0, 0, 5, 0);
		gbc_textField_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_email.gridx = 1;
		gbc_textField_email.gridy = 3;
		panel_4.add(textField_email, gbc_textField_email);
		textField_email.setColumns(10);
		
		JLabel lbl_saludo = new JLabel("Saludo");
		lbl_saludo.setVerticalAlignment(SwingConstants.TOP);
		lbl_saludo.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		GridBagConstraints gbc_lbl_saludo = new GridBagConstraints();
		gbc_lbl_saludo.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_saludo.gridx = 0;
		gbc_lbl_saludo.gridy = 4;
		panel_4.add(lbl_saludo, gbc_lbl_saludo);
		
		JTextArea textArea_saludo = new JTextArea();
		GridBagConstraints gbc_textArea_saludo = new GridBagConstraints();
		gbc_textArea_saludo.fill = GridBagConstraints.BOTH;
		gbc_textArea_saludo.gridx = 1;
		gbc_textArea_saludo.gridy = 4;
		panel_4.add(textArea_saludo, gbc_textArea_saludo);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Foto de perfil", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		
		JLabel lblPFP = new JLabel("");
		lblPFP.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_5.add(lblPFP);
		ImageIcon pfp = new ImageIcon(getClass().getResource("/images/usuario.png"));
		lblPFP.setIcon(new ImageIcon(pfp.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel_5.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		frmAppchatSignup.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btn_aceptar = new JButton("Aceptar");
		panel_1.add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("Cancelar");
		panel_1.add(btn_cancelar);
		
		addManejadorCancelar(btn_cancelar);
		addManejadorAceptar(btn_aceptar);
	}
	
	private void addManejadorAceptar(JButton btn_aceptar) {
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Registro Foto
				try {
					controller.register(textField_telefono.getText(), textField_nombre.getText(),
							textField_email.getText(), new String(passwordField.getPassword()), 
							new String(passwordField_confirmar.getPassword()),
							date_fechan.getDate().toInstant()
						      .atZone(ZoneId.systemDefault())
						      .toLocalDate());
					controller.mostrarLogin();
					frmAppchatSignup.dispose();
				}
				catch (UserException ex) {
					JOptionPane.showMessageDialog(btn_aceptar, ex.getMessage());
				}
			}
		});
	}
	
	private void addManejadorCancelar(JButton btn_cancelar) {
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostrarLogin();
				frmAppchatSignup.dispose();
			}
		});
	}
	
	private void addManejadorFoto(JButton btn_foto) {
		btn_foto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

}
