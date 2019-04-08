package com.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biblioteca.model.Categoria;
import com.biblioteca.model.Editora;
import com.biblioteca.repository.CategoriaRepository;
import com.biblioteca.repository.EditoraRepository;

@SpringBootApplication
public class SistemaEcommerceServerApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repoCategoria;
	@Autowired
	private EditoraRepository repoEditora;

	public static void main(String[] args) {
		SpringApplication.run(SistemaEcommerceServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria("Ação");
		Categoria cat2 = new Categoria("Aventura");
		Categoria cat3 = new Categoria("Comédia");
		Categoria cat4 = new Categoria("Cinema e Arte");
		Categoria cat5 = new Categoria("Terror");
		this.repoCategoria.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));

		Editora edit1 = new Editora("Globo Filmes");
		Editora edit2 = new Editora("Metro Goldwyn Mayer");
		Editora edit3 = new Editora("Paramount Motion Pictures Group");
		Editora edit4 = new Editora("21st Century Fox");
		Editora edit5 = new Editora("Universal Pictures");
		this.repoEditora.saveAll(Arrays.asList(edit1,edit2,edit3,edit4,edit5));

	}

}
