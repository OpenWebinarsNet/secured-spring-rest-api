package com.openwebinars.rest.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Producto.class )
public class Producto {

	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	
	private float precio;
	
	private String imagen;
	
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	//@JsonBackReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
//	@ManyToMany(mappedBy="productos", fetch = FetchType.EAGER)
	@ManyToMany(mappedBy="productos")
	@Builder.Default
	private Set<Lote> lotes = new HashSet<>();
	
	
}
