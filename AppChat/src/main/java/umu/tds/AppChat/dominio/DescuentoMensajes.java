package umu.tds.AppChat.dominio;

public class DescuentoMensajes implements Descuento {

	@Override
	public double calcularTotal(Usuario u) {
		long nMensajes = u.getNMensajes();
		
		if(nMensajes > 5000 && nMensajes <= 10000) return 9;
		if(nMensajes > 10000) return 8;
		return 10;
	}

}
