package com.openwebinars.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.openwebinars.rest.dto.CreatePedidoDto;
import com.openwebinars.rest.dto.GetPedidoDto;
import com.openwebinars.rest.dto.converter.PedidoDtoConverter;
import com.openwebinars.rest.error.exceptions.PedidoNotFoundException;
import com.openwebinars.rest.modelo.Pedido;
import com.openwebinars.rest.service.PedidoServicio;
import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.model.UserRole;
import com.openwebinars.rest.util.pagination.PaginationLinksUtils;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

	private final PedidoServicio pedidoServicio;
	private final PaginationLinksUtils paginationLinksUtils;
	private final PedidoDtoConverter pedidoDtoConverter;

	@GetMapping("/")
	public ResponseEntity<?> pedidos(Pageable pageable, HttpServletRequest request,
			@AuthenticationPrincipal UserEntity user) throws PedidoNotFoundException {
		Page<Pedido> result = null;
		// Si es administrador, puede ver todos los pedidos; si no, solo verá los
		// propios
		if (user.getRoles().contains(UserRole.ADMIN)) {
			result = pedidoServicio.findAll(pageable);
		} else {
			result = pedidoServicio.findAllByUser(user, pageable);
		}

		if (result.isEmpty()) {
			throw new PedidoNotFoundException();
		} else {

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

			Page<GetPedidoDto> dtoPage = result.map(pedidoDtoConverter::convertPedidoToGetPedidoDto);

			return ResponseEntity.ok().header("link", paginationLinksUtils.createLinkHeader(result, uriBuilder))
					.body(dtoPage);

		}
	}

	@PostMapping("/")
	public ResponseEntity<GetPedidoDto> nuevoPedido(@RequestBody CreatePedidoDto pedido, @AuthenticationPrincipal UserEntity user) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(pedidoDtoConverter.convertPedidoToGetPedidoDto(pedidoServicio.nuevoPedido(pedido, user)));
	}

}

