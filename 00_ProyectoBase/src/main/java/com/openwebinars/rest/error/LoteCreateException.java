package com.openwebinars.rest.error;

public class LoteCreateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6656042484402959674L;
	
	public LoteCreateException() {
		super("Error al crear un nuevo lote");
	}

}
