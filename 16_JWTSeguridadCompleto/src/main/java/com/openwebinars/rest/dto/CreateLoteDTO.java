package com.openwebinars.rest.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class CreateLoteDTO {
	
	private String nombre;
	@Builder.Default
	private List<Long> productos = new ArrayList<>();

}
