package umu.tds.AppChat.vista.observer;

public interface ChatListener {

	public void enviarMensaje(MensajeEvent e);
	public void recibirMensaje(MensajeEvent e);
	public void abrirChat(AbrirChatEvent e);
}
