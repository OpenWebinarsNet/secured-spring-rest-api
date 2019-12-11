package com.openwebinars.rest.service;

import org.springframework.stereotype.Service;

import com.openwebinars.rest.modelo.Categoria;
import com.openwebinars.rest.repos.CategoriaRepositorio;
import com.openwebinars.rest.service.base.BaseService;

@Service
public class CategoriaServicio extends BaseService<Categoria, Long, CategoriaRepositorio>{

}
