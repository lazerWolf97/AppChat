package umu.tds.AppChat.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import umu.tds.AppChat.controller.CrearContactoController;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class CrearContactoView {

	private JFrame frmCrearContacto;
	private JTextField textField_tlf;
	private JTextField textField_nombre;
	
	private CrearContactoController controller;

	/**
	 * Create the application.
	 */
	public CrearContactoView(CrearContactoController controller) {
		this.controller = controller;
		initialize();
	}
	
	public void showWindow() {
		frmCrearContacto.setVisible(true);
		frmCrearContacto.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrearContacto = new JFrame();
		frmCrearContacto.setResizable(false);
		frmCrearContacto.setTitle("Crear contacto");
		frmCrearContacto.setBounds(100, 100, 450, 200);
		frmCrearContacto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(8, 8, 8, 8));
		frmCrearContacto.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblIcon = new JLabel("");
		panel.add(lblIcon);
		ImageIcon pfp = new ImageIcon(getClass().getResource("/images/plususuario.png"));
		lblIcon.setIcon(new ImageIcon(pfp.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		
		JPanel panel_1 = new JPanel();
		frmCrearContacto.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btn_crear_contacto = new JButton("Crear Contacto");
		panel_1.add(btn_crear_contacto);
		
		JButton btn_cancelar = new JButton("Cancelar");
		panel_1.add(btn_cancelar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(50, 10, 50, 20));
		frmCrearContacto.getContentPane().add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lbl_telefono = new JLabel("Teléfono");
		GridBagConstraints gbc_lbl_telefono = new GridBagConstraints();
		gbc_lbl_telefono.anchor = GridBagConstraints.EAST;
		gbc_lbl_telefono.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_telefono.gridx = 0;
		gbc_lbl_telefono.gridy = 0;
		panel_2.add(lbl_telefono, gbc_lbl_telefono);
		
		textField_tlf = new JTextField();
		GridBagConstraints gbc_textField_tlf = new GridBagConstraints();
		gbc_textField_tlf.insets = new Insets(0, 0, 5, 0);
		gbc_textField_tlf.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_tlf.gridx = 1;
		gbc_textField_tlf.gridy = 0;
		panel_2.add(textField_tlf, gbc_textField_tlf);
		textField_tlf.setColumns(10);
		
		JLabel lbl_nombre = new JLabel("Nombre de Contacto");
		GridBagConstraints gbc_lbl_nombre = new GridBagConstraints();
		gbc_lbl_nombre.anchor = GridBagConstraints.EAST;
		gbc_lbl_nombre.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_nombre.gridx = 0;
		gbc_lbl_nombre.gridy = 1;
		panel_2.add(lbl_nombre, gbc_lbl_nombre);
		
		textField_nombre = new JTextField();
		GridBagConstraints gbc_textField_nombre = new GridBagConstraints();
		gbc_textField_nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_nombre.gridx = 1;
		gbc_textField_nombre.gridy = 1;
		panel_2.add(textField_nombre, gbc_textField_nombre);
		textField_nombre.setColumns(10);
		
		addManejadorCrear(btn_crear_contacto);
		addManejadorCancelar(btn_cancelar);
	}
	
	private void addManejadorCrear(JButton btn_crear_contacto) {
		btn_crear_contacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.crearContacto(textField_nombre.getText(), textField_tlf.getText());
				controller.mostrarVentanaPrincipal();
				
				frmCrearContacto.dispose();
			}
		});
	}
	
	private void addManejadorCancelar(JButton btn_cancelar) {
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostrarVentanaPrincipal();
				frmCrearContacto.dispose();
			}
		});
	}
	

}
