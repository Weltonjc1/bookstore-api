package com.welton.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welton.bookstore.domain.Categoria;
import com.welton.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired CategoriaRepository repository;
	public Categoria findById(Integer id) {
		
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
}
