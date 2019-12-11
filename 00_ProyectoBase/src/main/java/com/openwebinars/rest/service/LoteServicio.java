package com.openwebinars.rest.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.openwebinars.rest.dto.CreateLoteDTO;
import com.openwebinars.rest.error.LoteCreateException;
import com.openwebinars.rest.modelo.Lote;
import com.openwebinars.rest.repos.LoteRepositorio;
import com.openwebinars.rest.service.base.BaseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoteServicio extends BaseService<Lote, Long, LoteRepositorio> {

	private final ProductoServicio productoServicio;
	
	@Override
	public Optional<Lote> findById(Long id) {
		return repositorio.findByIdJoinFetch(id);
	}

	public Lote nuevoLote(CreateLoteDTO nuevoLote) {
		
		Lote l = Lote.builder()
					.nombre(nuevoLote.getNombre())
					.build();
		
		nuevoLote.getProductos().stream()
			.map(id -> {
				return productoServicio.findByIdConLotes(id).orElseThrow(() -> new LoteCreateException());
			})
			.forEach(l::addProducto);
			
		return save(l);
		
	}
	
	

}
