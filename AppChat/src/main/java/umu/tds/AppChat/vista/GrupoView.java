package umu.tds.AppChat.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class GrupoView {

	private JFrame frmAppchatCrear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrupoView window = new GrupoView();
					window.frmAppchatCrear.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GrupoView() {
		initialize();
	}
	
	public void showWindow() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchatCrear = new JFrame();
		frmAppchatCrear.setResizable(false);
		frmAppchatCrear.setTitle("AppChat - Crear grupo");
		frmAppchatCrear.setBounds(100, 100, 640, 480);
		frmAppchatCrear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 0, 10));
		frmAppchatCrear.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Lista de Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(8, 8, 8, 8));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		JList list_contactos = new JList();
		scrollPane_1.setViewportView(list_contactos);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JButton btn_add = new JButton(">>");
		panel_4.add(btn_add);
		
		JButton btn_remove = new JButton("<<");
		panel_4.add(btn_remove);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EmptyBorder(8, 8, 8, 8), "Contactos inclu\u00EDdos en el grupo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		JList list_grupo = new JList();
		scrollPane.setViewportView(list_grupo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAppchatCrear.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btn_crear = new JButton("Crear Grupo");
		panel_2.add(btn_crear);
		
		JButton btn_cancelar = new JButton("Cancelar");
		panel_2.add(btn_cancelar);
	}

}
