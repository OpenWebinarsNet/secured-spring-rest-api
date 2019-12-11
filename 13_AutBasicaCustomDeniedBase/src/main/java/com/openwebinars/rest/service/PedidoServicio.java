package com.openwebinars.rest.service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.openwebinars.rest.dto.CreatePedidoDto;
import com.openwebinars.rest.modelo.LineaPedido;
import com.openwebinars.rest.modelo.Pedido;
import com.openwebinars.rest.modelo.Producto;
import com.openwebinars.rest.repos.PedidoRepositorio;
import com.openwebinars.rest.service.base.BaseService;
import com.openwebinars.rest.users.model.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepositorio> {
	
	private final ProductoServicio productoServicio;
	
	public Pedido nuevoPedido(CreatePedidoDto nuevo, UserEntity cliente) {
		
		return save(Pedido.builder()
				.cliente(cliente)
				.lineas(nuevo.getLineas().stream()
							.map(lineaDto -> {
								
								Optional<Producto> p = productoServicio.findById(lineaDto.getProductoId());								
								if (p.isPresent()) {
									Producto producto = p.get();
									return LineaPedido.builder()
											.cantidad(lineaDto.getCantidad())
											.precio(producto.getPrecio())
											.producto(producto)
											.build();
								} else {
									return null;
								}
							})
							.filter(Objects::nonNull)
							.collect(Collectors.toSet())
						)							
				.build());
		
		
	}

	public Page<Pedido> findAllByUser(UserEntity user, Pageable pageable) {
		return repositorio.findByCliente(user, pageable);
	}

}
