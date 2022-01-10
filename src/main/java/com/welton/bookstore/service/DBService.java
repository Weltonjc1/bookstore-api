package com.welton.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welton.bookstore.domain.Categoria;
import com.welton.bookstore.domain.Livro;
import com.welton.bookstore.repositories.CategoriaRepository;
import com.welton.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção cientifica", "Ficção cientifica");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Louis Gerstner", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "Wells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "Flash", "Flash", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "Superman", "Isaac", "Lorem ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
