package com.welton.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welton.bookstore.domain.Livro;
import com.welton.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository repository;

	public Livro findById(Integer id) {

		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new com.welton.bookstore.service.exception.ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + "Type: " + Livro.class.getName()));
	}

	public List<Livro> findALL() {
		return repository.findAll();
	}

}
