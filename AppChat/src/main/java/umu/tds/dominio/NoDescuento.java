package umu.tds.dominio;

public class NoDescuento implements Descuento {

	@Override
	public double calcularTotal(Usuario u) {
		return 10;
	}

}
