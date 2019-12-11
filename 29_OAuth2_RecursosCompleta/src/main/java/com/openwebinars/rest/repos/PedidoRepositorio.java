package com.openwebinars.rest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openwebinars.rest.modelo.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
	
	

}
