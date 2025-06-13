package umu.tds.AppChat.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class LoginView {

	private JFrame frmAppchatLogin;
	private JTextField textField_tlf;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frmAppchatLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}
	
	public void showWindow() {
		frmAppchatLogin.setLocationRelativeTo(null);
		frmAppchatLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchatLogin = new JFrame();
		frmAppchatLogin.setTitle("AppChat - Login");
		frmAppchatLogin.setResizable(false);
		frmAppchatLogin.setBounds(100, 100, 450, 300);
		frmAppchatLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchatLogin.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_title = new JPanel();
		frmAppchatLogin.getContentPane().add(panel_title, BorderLayout.NORTH);
		
		JLabel label_title = new JLabel("AppChat");
		label_title.setFont(new Font("Roboto Condensed", Font.BOLD, 38));
		panel_title.add(label_title);
		
		JPanel panel_window = new JPanel();
		panel_window.setBorder(new EmptyBorder(2, 8, 8, 8));
		frmAppchatLogin.getContentPane().add(panel_window, BorderLayout.CENTER);
		panel_window.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_login = new JPanel();
		panel_login.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_window.add(panel_login, BorderLayout.CENTER);
		panel_login.setLayout(new BoxLayout(panel_login, BoxLayout.Y_AXIS));
		
		JPanel panel_tlf = new JPanel();
		panel_tlf.setBorder(new EmptyBorder(5, 5, 2, 5));
		panel_login.add(panel_tlf);
		panel_tlf.setLayout(new BoxLayout(panel_tlf, BoxLayout.Y_AXIS));
		
		JPanel panel_tlftitle = new JPanel();
		panel_tlf.add(panel_tlftitle);
		
		JLabel lbl_tlf = new JLabel("Teléfono");
		lbl_tlf.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		panel_tlftitle.add(lbl_tlf);
		
		JPanel panel_tlffield = new JPanel();
		panel_tlf.add(panel_tlffield);
		
		textField_tlf = new JTextField();
		panel_tlffield.add(textField_tlf);
		textField_tlf.setColumns(20);
		
		JPanel panel_password = new JPanel();
		panel_password.setBorder(new EmptyBorder(2, 5, 5, 5));
		panel_login.add(panel_password);
		panel_password.setLayout(new BoxLayout(panel_password, BoxLayout.Y_AXIS));
		
		JPanel panel_passtitle = new JPanel();
		panel_password.add(panel_passtitle);
		
		JLabel lbl_passtitle = new JLabel("Contraseña");
		lbl_passtitle.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		panel_passtitle.add(lbl_passtitle);
		
		JPanel panel_9 = new JPanel();
		panel_password.add(panel_9);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		panel_9.add(passwordField);
		
		JPanel panel_buttons = new JPanel();
		panel_window.add(panel_buttons, BorderLayout.SOUTH);
		panel_buttons.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_signup = new JPanel();
		panel_buttons.add(panel_signup, BorderLayout.WEST);
		
		JButton btn_signup = new JButton("Signup");
		panel_signup.add(btn_signup);
		
		JPanel panel_loginbuttons = new JPanel();
		panel_buttons.add(panel_loginbuttons, BorderLayout.EAST);
		
		JButton btn_aceptar = new JButton("Aceptar");
		panel_loginbuttons.add(btn_aceptar);
		
		JButton btn_salir = new JButton("Salir");
		panel_loginbuttons.add(btn_salir);
		
		addManejadorSalir(btn_salir);
		addManejadorSignup(btn_signup);
	}

	
	private void addManejadorSalir(JButton btn_salir) {
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAppchatLogin.dispose();
				System.exit(0);
			}
		});
	}
	
	private void addManejadorSignup(JButton btn_signup) {
		btn_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupView frmAppchatSignup = new SignupView();
				frmAppchatSignup.showWindow();
				frmAppchatLogin.dispose();
			}
		});
	}
	
	private void addManejadorAceptar(JButton btn_aceptar) {
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Comprobar Login
			}
		});
	}
}
