package umu.tds.AppChat.vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;

public class SearchView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchView window = new SearchView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(new Color(0, 0, 0), 2, true)));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(8, 8, 8, 8));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel lblicon = new JLabel("");
		ImageIcon search = new ImageIcon(getClass().getResource("/images/lupa.png"));
		lblicon.setIcon(new ImageIcon(search.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		lblicon.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblicon);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Buscar contacto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(2, 2, 2, 2));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Texto ");
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(2, 2, 2, 2));
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_2 = new JLabel("Teléfono ");
		panel_4.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut);
		
		JLabel lblNewLabel_3 = new JLabel("Contacto ");
		panel_4.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(8, 8, 8, 8));
		frame.getContentPane().add(panel_5, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Buscar");
		panel_5.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel_5.add(btnNewButton_1);
	}

}
