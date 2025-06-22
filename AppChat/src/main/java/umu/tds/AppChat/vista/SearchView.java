package umu.tds.AppChat.vista;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.border.TitledBorder;

import umu.tds.AppChat.controller.SearchController;
import umu.tds.AppChat.dominio.Mensaje;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SearchView {

	private JFrame frmSearch;
	private JTextField textField_texto;
	private JTextField text_nombre;
	private JComboBox comboBox;
	private JPanel panel_mensajes;
	
	private SearchController controller;

	/**
	 * Create the application.
	 */
	public SearchView(SearchController controller) {
		this.controller = controller;
		initialize();
	}
	
	public void showWindow() {
		frmSearch.setLocationRelativeTo(null);
		frmSearch.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearch = new JFrame();
		frmSearch.setTitle("Buscar mensajes");
		frmSearch.setBounds(100, 100, 450, 600);
		frmSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel_mensajes = new JPanel();
		panel_mensajes.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(new Color(0, 0, 0), 2, true)));
		frmSearch.getContentPane().add(panel_mensajes, BorderLayout.CENTER);
		panel_mensajes.setLayout(new BoxLayout(panel_mensajes, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(8, 8, 8, 8));
		frmSearch.getContentPane().add(panel_1, BorderLayout.NORTH);
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
		
		textField_texto = new JTextField();
		panel_3.add(textField_texto);
		textField_texto.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(2, 2, 2, 2));
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_2 = new JLabel("De ");
		panel_4.add(lblNewLabel_2);
		
		text_nombre = new JTextField();
		panel_4.add(text_nombre);
		text_nombre.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut);
		
		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(2);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Contacto", "Teléfono"}));
		panel_4.add(comboBox);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(8, 8, 8, 8));
		frmSearch.getContentPane().add(panel_5, BorderLayout.SOUTH);
		
		JButton btn_buscar = new JButton("Buscar");
		panel_5.add(btn_buscar);
		
		JButton btn_cancelar = new JButton("Cancelar");
		panel_5.add(btn_cancelar);
		
		addManejadorBuscar(btn_buscar);
		addManejadorCancelar(btn_cancelar);
	}
	
	private void addManejadorBuscar(JButton btn_buscar) {
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMensajesNumero();
				
			}
		});
	}
	
	private void addManejadorCancelar(JButton btn_cancelar) {
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSearch.dispose();
			}
		});
	}
	
	private void mostrarMensajesNumero() {
		panel_mensajes.removeAll();
		
		List<Mensaje> listaMensajes;
		
		// JPanel listaPanel = new MensajePanel?
		JPanel listaPanel = new JPanel();
		listaPanel.setLayout(new BoxLayout(listaPanel, BoxLayout.Y_AXIS));
		if(comboBox.getSelectedIndex() == 1)
			controller.setMetodoBusqueda("NUMERO");
		else
			controller.setMetodoBusqueda("CONTACTO");
		
		listaMensajes = controller.buscarMensajes(textField_texto.getText(), text_nombre.getText());
		
		for(Mensaje m : listaMensajes) {
			MensajePanel mp = new MensajePanel(m.getTexto(), m.getEmisor().getNumTLF(), m.getReceptor().getNumTLF(), m.getFechaHora());
			listaPanel.add(mp);
		}
		
	    JScrollPane scrollPane = new JScrollPane(listaPanel);
	    scrollPane.setBorder(null);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	    panel_mensajes.setLayout(new BorderLayout());
	    panel_mensajes.add(scrollPane, BorderLayout.CENTER);
	    panel_mensajes.revalidate();
	    panel_mensajes.repaint();
	}

}
