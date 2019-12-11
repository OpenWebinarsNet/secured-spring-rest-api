package com.openwebinars.rest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openwebinars.rest.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
