package com.algaworks.socialbooks.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutorRepository;
import com.algaworks.socialbooks.service.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.service.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	@Autowired
	private AutorRepository autorRepository;

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<Autor> listar() {
	    List<Autor> autors = autorRepository.findAll();
	    try {
	        Thread.sleep(4000);
	    } catch (InterruptedException e) {
	    }
		return autors;
	}
	
	
	@Transactional
	public Autor salvar(Autor autor) {
        if(autor.getId() != null) {
            Autor a = autorRepository.findOne(autor.getId());
            if(a != null) {
                throw new AutorExistenteException("O autor já existe.");
            }
        }
        
        Autor autorExistente = autorRepository.findByNome(autor.getNome());
        if(autorExistente != null) {
            autorExistente.setDataNascimento(new Date());
            autorExistente.setNome("weliff 2");
            autor = autorExistente;
        }
        autorRepository.save(autor);
        
//        for (int i = 0; i < 15; i++) {
//           Autor a = new Autor();
//           a.setDataNascimento(new Date());
//           a.setNacionalidade("br");
//           a.setNome("asdasd");
//           autorRepository.saveAndFlush(a);
//        }
        
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
        return autor;
	}
	
	public Autor buscar(Long id) {
		Autor autor = autorRepository.findOne(id);
		if(autor == null) {
			throw new AutorNaoEncontradoException("O autor não pode ser encontrado.");
		}
		return autor;
	}
}
