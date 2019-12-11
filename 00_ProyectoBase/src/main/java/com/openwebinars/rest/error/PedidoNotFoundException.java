package com.openwebinars.rest.error;

public class PedidoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2730111931833397903L;

	public PedidoNotFoundException() {
		super("No se han encontrado pedidos");
	}

	public PedidoNotFoundException(Long id) {
		super("No se ha encontrado ningún pedido con el ID " + id);
	}
	
	

}
