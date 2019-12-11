package com.openwebinars.rest.service;

import org.springframework.stereotype.Service;

import com.openwebinars.rest.modelo.Pedido;
import com.openwebinars.rest.repos.PedidoRepositorio;
import com.openwebinars.rest.service.base.BaseService;

@Service
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepositorio> {

}
