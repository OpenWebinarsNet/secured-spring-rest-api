package com.openwebinars.rest.error;

public class SearchProductoNoResultException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -889312292404205516L;
	
	
	public SearchProductoNoResultException() {
		super("La búsqueda de productos no produjo resultados");
	}
	
	public SearchProductoNoResultException(String txt) {
		super(String.format("El término de búsqueda %s no produjo resultados", txt));
	}
	
	
}
