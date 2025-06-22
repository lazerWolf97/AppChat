package umu.tds.AppChat.vista.observer;

import java.util.EventListener;

public interface PerfilListener extends EventListener {
	void updatePerfil(PerfilEvent e);
	void setPremium();
}
