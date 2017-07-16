package com.algaworks.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Livro {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message="O campo nomde deve ser informado.")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date publicacao;

	@JsonInclude(Include.NON_NULL)
	private String editora;
	
	@JsonInclude(Include.NON_NULL)
	private String resumo;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy="livro")
	private List<Comentario> comentarios;
	
	@ManyToOne
	@JoinColumn(name="AUTOR_ID")
	@JsonInclude(Include.NON_NULL)
	private Autor autor;
	
	public Livro(String nome) {
		this.nome = nome;
	}
	
	public Livro(Livro livro, Long id) {
		this.id = id;
		this.nome = livro.nome;
		this.comentarios = livro.comentarios;
		this.editora = livro.editora;
		this.publicacao = livro.publicacao;
		this.resumo = livro.resumo;
		this.autor = livro.autor;
	}
	
	public Livro (){
		
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Date getPublicacao() {
		return publicacao;
	}
	public String getEditora() {
		return editora;
	}
	public String getResumo() {
		return resumo;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public Autor getAutor() {
		return autor;
	}
	

}
