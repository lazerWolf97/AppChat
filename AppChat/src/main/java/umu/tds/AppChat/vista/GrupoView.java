package umu.tds.AppChat.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;

import umu.tds.AppChat.controller.CrearGrupoController;
import umu.tds.AppChat.dominio.ContactoIndividual;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GrupoView {

	private JFrame frmAppchatCrear;
	
	private JList<ContactoIndividual> list_contactos;
	private JList<ContactoIndividual> list_grupo;
	
	private JTextField textField_nombre;
	
	private CrearGrupoController controller;
	
	private DefaultListModel<ContactoIndividual> modelContactos = new DefaultListModel<>();
	private DefaultListModel<ContactoIndividual> modelGrupo = new DefaultListModel<>();

	/**
	 * Create the application.
	 */
	public GrupoView(CrearGrupoController controller) {
		this.controller = controller;
		initialize();
	}
	
	public void showWindow() {
		frmAppchatCrear.setLocationRelativeTo(null);
		frmAppchatCrear.setVisible(true);
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
		
		list_contactos = new JList<>(modelContactos);
		controller.getContactos().stream()
					.forEach(c -> modelContactos.addElement(c));
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
		
		list_grupo = new JList(modelGrupo);
		scrollPane.setViewportView(list_grupo);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_5.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Nombre del grupo ");
		panel_6.add(lblNewLabel, BorderLayout.WEST);
		
		textField_nombre = new JTextField();
		panel_6.add(textField_nombre, BorderLayout.CENTER);
		textField_nombre.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAppchatCrear.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btn_crear = new JButton("Crear Grupo");
		panel_2.add(btn_crear);
		
		JButton btn_cancelar = new JButton("Cancelar");
		panel_2.add(btn_cancelar);
		
		addManejadorAceptar(btn_crear);
		addManejadorCancelar(btn_cancelar);
		addManejadorAdd(btn_add);
		addManejadorRemove(btn_remove);
	}
	
	private void addManejadorAceptar(JButton btn_crear) {
		btn_crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ContactoIndividual> lc = new LinkedList<ContactoIndividual>();
				for(int i = 0; i < modelGrupo.getSize(); i++) {
					lc.add(modelGrupo.get(i));
				}
				controller.crearGrupo(lc, textField_nombre.getText());
				controller.mostrarVentanaPrincipal();
				frmAppchatCrear.dispose();
			}
		});
	}
	
	private void addManejadorCancelar(JButton btn_cancelar) {
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostrarVentanaPrincipal();
				frmAppchatCrear.dispose();
			}
		});
	}
	
	private void addManejadorAdd(JButton btn_add) {
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactoIndividual ci = list_contactos.getSelectedValue();
				int index = list_contactos.getSelectedIndex();
				modelGrupo.addElement(ci);
				modelContactos.remove(index);
			}
		});
	}
	
	private void addManejadorRemove(JButton btn_remove) {
		btn_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactoIndividual ci = list_grupo.getSelectedValue();
				int index = list_grupo.getSelectedIndex();
				modelContactos.addElement(ci);
				modelGrupo.remove(index);
			}
		});
	}

}
