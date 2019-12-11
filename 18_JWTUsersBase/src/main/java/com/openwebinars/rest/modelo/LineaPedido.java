package com.openwebinars.rest.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table(name = "linea_pedido")
public class LineaPedido {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	private float precio;

	private int cantidad;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	
	public float getSubtotal() {
		return precio*cantidad;
	}

}
