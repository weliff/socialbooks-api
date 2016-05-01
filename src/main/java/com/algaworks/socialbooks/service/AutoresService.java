package com.algaworks.socialbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutorRepository;
import com.algaworks.socialbooks.service.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.service.exceptions.AutorNaoEncontradoException;

@RestController
@RequestMapping("/autores")
public class AutoresService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public List<Autor> listar() {
		return autorRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autorRepository.findOne(autor.getId());
			if(a != null) {
				throw new AutorExistenteException("O autor já existe.");
			}
		}
		return autorRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Autor autor = autorRepository.findOne(id);
		if(autor == null) {
			throw new AutorNaoEncontradoException("O autor não pode ser encontrado.");
		}
		return autor;
	}
}
