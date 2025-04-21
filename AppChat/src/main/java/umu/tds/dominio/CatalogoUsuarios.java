package umu.tds.dominio;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CatalogoUsuarios {

	private static CatalogoUsuarios unicaInstancia;
	private Map<String, Usuario> usuarios;
	
	private CatalogoUsuarios() {
		usuarios = new HashMap<String, Usuario>();
	}
	
	public CatalogoUsuarios getCatalogo() {
		if(unicaInstancia == null) {
			unicaInstancia = new CatalogoUsuarios();
		}
		return unicaInstancia;
	}
	
	public Map<String, Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void add(Usuario u) {
		usuarios.put(u.getNumTLF(), u);
	}
	
	public Optional<Usuario> getUsuario(String numTLF){
		return Optional.ofNullable(usuarios.get(numTLF));
	}
	
	public void delete(String numTLF) {
		usuarios.remove(numTLF);
	}
}
