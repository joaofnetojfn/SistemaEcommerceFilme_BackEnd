package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Integer>{
	
}