package umu.tds.AppChat.vista.observer;

import umu.tds.AppChat.dominio.Contacto;

public interface ChatListener {

	public void enviarMensaje(MensajeEvent e);
	public void recibirMensaje(MensajeEvent e);
	public void abrirChat(AbrirChatEvent e);
	public void eliminarContacto(Contacto c);
}
