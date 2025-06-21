package umu.tds.AppChat.vista.observer;

public interface ChatListener {

	public void enviarMensaje(String mensaje);
	public void recibirMensaje(String mensaje);
	public void abrirChat(String numTLF, String nombre);
}
