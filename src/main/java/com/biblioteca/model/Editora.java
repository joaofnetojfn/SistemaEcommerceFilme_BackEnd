package com.biblioteca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Editora implements Serializable {
	public int getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEditora;
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy="editora")
	private List<Filme> filmes = new ArrayList<>();

	public Editora(String nome) {
		this.nome = nome;
	}
	
}
