package umu.tds.AppChat.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import umu.tds.AppChat.controller.ChatController;
import umu.tds.AppChat.controller.MensajeGrupoController;
import umu.tds.AppChat.dominio.Contacto;
import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Grupo;
import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.vista.observer.AbrirChatEvent;
import umu.tds.AppChat.vista.observer.ChatListener;
import umu.tds.AppChat.vista.observer.GrupoListener;
import umu.tds.AppChat.vista.observer.MensajeEvent;
import umu.tds.AppChat.vista.observer.PerfilEvent;
import umu.tds.AppChat.vista.observer.PerfilListener;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

public class MainView implements PerfilListener, ChatListener, GrupoListener {

	private JFrame frmAppchat;
	private JPanel panel_chat;
	private JPanel panel_mensajes;
	private JComboBox<Contacto> comboBox;
	
	private JButton btn_perfil;
	
	private ChatController controller;
	
	private DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("[dd/MM/yyyy] HH:mm");

	/**
	 * Create the application.
	 */
	public MainView(ChatController controller) {
		this.controller = controller;
		controller.addChatListener(this);
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
		
		JPanel panel_funciones = new JPanel();
		panel_funciones.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2, true), new EmptyBorder(4, 4, 4, 4))));
		frmAppchat.getContentPane().add(panel_funciones, BorderLayout.NORTH);
		panel_funciones.setLayout(new BoxLayout(panel_funciones, BoxLayout.X_AXIS));
		
		comboBox = new JComboBox<Contacto>();
		controller.getContactos().stream().forEach(c -> comboBox.addItem(c));
		panel_funciones.add(comboBox);
		
		JButton btn_abrirchat = new JButton("Abrir Chat");
		panel_funciones.add(btn_abrirchat);
		
		JButton btn_nuevogrupo = new JButton("Nuevo Grupo");
		panel_funciones.add(btn_nuevogrupo);
		
		JButton btn_nuevocontacto = new JButton("Nuevo Contacto");
		panel_funciones.add(btn_nuevocontacto);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_funciones.add(horizontalGlue);
		
		JButton btn_buscar = new JButton("Buscar mensajes");
		panel_funciones.add(btn_buscar);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_funciones.add(horizontalGlue_1);
		
		btn_perfil = new JButton(controller.getCurrentUsername());
		panel_funciones.add(btn_perfil);
		
		panel_mensajes = new JPanel();
		panel_mensajes.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Chats", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		frmAppchat.getContentPane().add(panel_mensajes, BorderLayout.WEST);
		panel_mensajes.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_mensajes.add(scrollPane, BorderLayout.CENTER);
		
		panel_chat = new JPanel();
		panel_chat.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(new Color(0, 0, 0), 2, true)));
		frmAppchat.getContentPane().add(panel_chat, BorderLayout.CENTER);
		panel_chat.setLayout(new BorderLayout(0, 0));
		
		addManejadorBuscar(btn_buscar);
		addManejadorNuevoContacto(btn_nuevocontacto);
		addManejadorAbrirChat(btn_abrirchat);
		addManejadorPerfil(btn_perfil);
		addManejadorNuevoGrupo(btn_nuevogrupo);
		mostrarChat("Bienvenido a AppChat!", "Inicio");
		
		mostrarListaChats();
	}
	
	private void addManejadorBuscar(JButton btn_buscar) {
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostrarSearch();
			}
		});
	}
	
	private void addManejadorNuevoContacto(JButton btn_nuevocontacto) {
		btn_nuevocontacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostrarCrearContacto();
				frmAppchat.dispose();
			}
		});
	}
	
	private void addManejadorNuevoGrupo(JButton btn_nuevogrupo) {
		btn_nuevogrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostrarCrearGrupo();
				frmAppchat.dispose();
			}
		});
	}
	
	private void addManejadorPerfil(JButton btn_perfil) {
		btn_perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mostrarPerfil(MainView.this);
			}
		});
	}
	
	private void addManejadorAbrirChat(JButton btn_abrirchat) {
		btn_abrirchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacto c = (Contacto) comboBox.getSelectedItem();
				
				if(c instanceof ContactoIndividual) {
					ContactoIndividual ci = (ContactoIndividual) c;
					mostrarChat(ci.getNombre(), ci.getNumTLF());
				}
				
				if(c instanceof Grupo) {
					Grupo g = (Grupo) c;
					controller.mostrarMensajeGrupo(g);
				}
			}
		});
	}
	
	private void mostrarChat(String nombreContacto, String telefono) {
	    panel_chat.removeAll();
	    ChatPanel chatPanel = new ChatPanel(controller, nombreContacto, telefono);
	    panel_chat.add(chatPanel, BorderLayout.CENTER);
	    panel_chat.revalidate();
	    panel_chat.repaint();
	}
	
	private void mostrarListaChats() {
		panel_mensajes.removeAll();
		
		// JPanel listaPanel = new MensajePanel?
		JPanel listaPanel = new JPanel();
		List<Mensaje> listaChats = controller.getUltimosMensajes();
		//new MensajePanel(m.getTexto(), m.getEmisor().getNumTLF(), m.getReceptor().getNumTLF());
		for(Mensaje m : listaChats) {
			boolean isEmisor = m.getEmisor().compararTLF(controller.getCurrentNumber());
			String contacto = isEmisor ? m.getReceptor().getNumTLF() : m.getEmisor().getNumTLF();
			String nombre = isEmisor ? m.getReceptor().getNombre() : m.getEmisor().getNombre();
			ChatPreviewPanel preview = new ChatPreviewPanel(m.getTexto(),
					contacto, nombre, m.getFechaHora(), isEmisor, controller);
			listaPanel.add(preview);
		}
		
	    JScrollPane scrollPane = new JScrollPane(listaPanel);
	    listaPanel.setLayout(new BoxLayout(listaPanel, BoxLayout.Y_AXIS));
	    scrollPane.setBorder(null);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	    panel_mensajes.setLayout(new BorderLayout());
	    panel_mensajes.add(scrollPane, BorderLayout.CENTER);
	    panel_mensajes.revalidate();
	    panel_mensajes.repaint();
	}

	@Override
	public void updatePerfil(PerfilEvent e) {
		btn_perfil.setText(e.getNombre());
	}

	@Override
	public void enviarMensaje(MensajeEvent e) {
		for (Component c : panel_chat.getComponents()) {
		    if (c instanceof ChatPanel cp) {
		        cp.agregarMensaje(e.getMensaje(), e.getFecha().format(formatter), true);
		        mostrarListaChats();
		    }
		}
	}

	@Override
	public void recibirMensaje(MensajeEvent e) {
		for (Component c : panel_chat.getComponents()) {
		    if (c instanceof ChatPanel cp) {
		    	if(cp.getTLFContacto().compareTo(e.getEmisor()) == 0) {
		    		cp.agregarMensaje(e.getMensaje(), e.getFecha().format(formatter), false);
		    	}
		    	
		    	mostrarListaChats();
		    }
		}
	}

	@Override
	public void abrirChat(AbrirChatEvent e) {
		mostrarChat(e.getNombre(), e.getNumTLF());
	}

	@Override
	public void enviarMensajeGrupo(MensajeEvent e) {
		for (Component c : panel_chat.getComponents()) {
		    if (c instanceof ChatPanel cp) {
		        cp.agregarMensaje(e.getMensaje(), e.getFecha().format(formatter), true);
		    }
		}
		panel_chat.revalidate();
		panel_chat.repaint();
		mostrarListaChats();
	}

	@Override
	public void setPremium() {
		panel_chat.revalidate();
		panel_chat.repaint();
		mostrarListaChats();
	}

}
