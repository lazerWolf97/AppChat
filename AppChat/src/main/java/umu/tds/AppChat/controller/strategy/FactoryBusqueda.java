package umu.tds.AppChat.controller.strategy;

public class FactoryBusqueda {

	public static Busqueda getBusqueda(String tipo) {
		
		return switch (tipo.toUpperCase()) {
			case "CONTACTO" -> new BusquedaContacto();
			case "NUMERO" -> new BusquedaNumero();
			default -> throw new IllegalArgumentException("Tipo de busqueda desconocido");
		};
	}
	
}
