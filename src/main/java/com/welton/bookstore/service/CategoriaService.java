package com.welton.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welton.bookstore.domain.Categoria;
import com.welton.bookstore.dtos.CategoriaDTO;
import com.welton.bookstore.repositories.CategoriaRepository;
import com.welton.bookstore.service.exception.DataIntegrityViolationException;


@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;

	public Categoria findById(Integer id) {

		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new com.welton.bookstore.service.exception.ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + "Type: " + Categoria.class.getName()));
	}

	public List<Categoria> findALL(){
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		// TODO Auto-generated method stub
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados ");
		}
		
		
		
	}
	
}
