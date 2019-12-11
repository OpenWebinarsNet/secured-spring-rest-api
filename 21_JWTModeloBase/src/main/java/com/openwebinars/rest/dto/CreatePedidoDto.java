package com.openwebinars.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePedidoDto {

	private List<CreateLineaPedidoDto> lineas;
	
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class CreateLineaPedidoDto {
		
		private int cantidad;
		private Long productoId;
		
	}
	
	
	
}
