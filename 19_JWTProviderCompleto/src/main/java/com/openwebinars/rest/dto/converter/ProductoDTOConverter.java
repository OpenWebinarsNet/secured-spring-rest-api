package com.openwebinars.rest.dto.converter;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.openwebinars.rest.dto.ProductoDTO;
import com.openwebinars.rest.modelo.Producto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductoDTOConverter {
	
	private final ModelMapper modelMapper;
	
	
	@PostConstruct
	public void init() {
		modelMapper.addMappings(new PropertyMap<Producto, ProductoDTO>() {

			@Override
			protected void configure() {
				map().setCategoria(source.getCategoria().getNombre());
			}
		});
	}
	
	/**
	 * Opción 1 con ModelMapper
	 * @param producto
	 * @return
	 */
	public ProductoDTO convertToDto(Producto producto) {
		return modelMapper.map(producto, ProductoDTO.class);
		
	}
	
	/**
	 * Opción 2 con Builder de Lombok
	 * @param producto
	 * @return
	 */
	public ProductoDTO convertProdutoToProductoDto(Producto producto) {
		return ProductoDTO.builder()
				.nombre(producto.getNombre())
				.imagen(producto.getImagen())
				.categoria(producto.getCategoria().getNombre())
				.id(producto.getId())
				.build();
	}
	
	
	
}
