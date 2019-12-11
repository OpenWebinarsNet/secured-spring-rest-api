package com.openwebinars.rest.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.openwebinars.rest.modelo.Pedido;
import com.openwebinars.rest.users.model.UserEntity;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
	
	Page<Pedido> findByCliente(UserEntity cliente, Pageable pageable);
	
	

}
