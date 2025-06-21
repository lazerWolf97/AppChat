package umu.tds.AppChat.dominio;

public class DescuentoFactory {

	public static Descuento getDescuento(String tipo) {
		
		return switch (tipo.toUpperCase()) {
			case "FECHA" -> new DescuentoFecha();
			case "MENSAJES" -> new DescuentoMensajes();
			default -> throw new IllegalArgumentException("Tipo de descuento desconocido");
		};
		
	}
	
}
