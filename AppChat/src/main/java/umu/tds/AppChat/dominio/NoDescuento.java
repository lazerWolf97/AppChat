package umu.tds.AppChat.dominio;

public class NoDescuento implements Descuento {

	@Override
	public double calcularTotal(Usuario u) {
		return 10;
	}

}
