package com.openwebinars.rest.error;

public class LoteNotFoundException extends Exception {



	/**
	 * 
	 */
	private static final long serialVersionUID = 3342034462033626819L;

	public LoteNotFoundException() {
		super("No se han encontrado lotes de productos");
	}

	public LoteNotFoundException(Long id) {
		super("No se ha encontrado ningún lote con el ID " + id);
	}
	
	

}