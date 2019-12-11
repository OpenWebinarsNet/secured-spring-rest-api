package com.openwebinars.rest.modelo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Pedido {

	
	@Id @GeneratedValue
	private Long id;
	
	private String cliente;
	
	@CreatedDate
	private LocalDateTime fecha;
	
	@EqualsAndHashCode.Exclude @ToString.Exclude
	@JsonManagedReference
	@Builder.Default
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<LineaPedido> lineas = new HashSet<>();
	
	public float getTotal() {
		return (float) lineas.stream()
			.mapToDouble(LineaPedido::getSubtotal)
			.sum();
	}
	
	/**
	 * Métodos helper
	 */
	
	public void addLineaPedido(LineaPedido lp) {
		lineas.add(lp);
		lp.setPedido(this);
	}
	
	public void removeLineaPedido(LineaPedido lp) {
		lineas.remove(lp);
		lp.setPedido(null);
	}
	
	
}
