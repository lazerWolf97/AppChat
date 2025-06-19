package umu.tds.AppChat.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import umu.tds.AppChat.controller.ChatController;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

public class MainView {

	private JFrame frmAppchat;
	private JPanel panel_chat;
	
	private ChatController controller;

	/**
	 * Create the application.
	 */
	public MainView(ChatController controller) {
		this.controller = controller;
		initialize();
	}
	
	public void showWindow() {
		frmAppchat.setLocationRelativeTo(null);
		frmAppchat.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppchat = new JFrame();
		frmAppchat.setTitle("AppChat");
		frmAppchat.setResizable(false);
		frmAppchat.setBounds(100, 100, 800, 600);
		frmAppchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppchat.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2, true), new EmptyBorder(4, 4, 4, 4))));
		frmAppchat.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JButton btn_nuevochat = new JButton("Nuevo Chat");
		panel.add(btn_nuevochat);
		
		JButton btn_nuevogrupo = new JButton("Nuevo Grupo");
		panel.add(btn_nuevogrupo);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		JButton btn_buscar = new JButton("Buscar mensajes");
		panel.add(btn_buscar);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
		
		JButton btn_premium = new JButton("Premium");
		panel.add(btn_premium);
		
		JButton btn_perfil = new JButton(controller.getCurrentUsername());
		panel.add(btn_perfil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Chats", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		frmAppchat.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		panel_chat = new JPanel();
		panel_chat.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(new Color(0, 0, 0), 2, true)));
		frmAppchat.getContentPane().add(panel_chat, BorderLayout.CENTER);
		panel_chat.setLayout(new BorderLayout(0, 0));
		
		addManejadorBuscar(btn_buscar);
		mostrarChat("David", "12345567");
	}
	
	private void addManejadorBuscar(JButton btn_buscar) {
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostrarSearch();
			}
		});
	}
	
	public void mostrarChat(String nombreContacto, String telefono) {
	    panel_chat.removeAll();
	    ChatPanel chatPanel = new ChatPanel(controller, nombreContacto, telefono);
	    panel_chat.add(chatPanel, BorderLayout.CENTER);
	    panel_chat.revalidate();
	    panel_chat.repaint();
	}

}
