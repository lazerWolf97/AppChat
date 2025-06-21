package umu.tds.AppChat.dominio;

public class DescuentoFecha implements Descuento {

	@Override
	public double calcularTotal(Usuario u) {
		double precio = 10 - u.getYearsOld();
		if(precio < 6) return 6;
		return precio;
	}

}
