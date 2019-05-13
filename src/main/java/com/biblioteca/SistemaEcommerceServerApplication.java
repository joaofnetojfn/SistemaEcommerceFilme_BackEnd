package com.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biblioteca.model.Categoria;
import com.biblioteca.model.Cliente;
import com.biblioteca.model.Editora;
import com.biblioteca.model.Filme;
import com.biblioteca.repository.CategoriaRepository;
import com.biblioteca.repository.ClienteRepository;
import com.biblioteca.repository.EditoraRepository;
import com.biblioteca.repository.FilmeRepository;

@SpringBootApplication
public class SistemaEcommerceServerApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repoCategoria;
	@Autowired
	private EditoraRepository repoEditora;
	@Autowired
	private ClienteRepository repoCliente;
	@Autowired
	private FilmeRepository repoFilme;

	public static void main(String[] args) {
		SpringApplication.run(SistemaEcommerceServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cli1 = new Cliente(null, "nome", "cargo", "endereco", "cidade", "cep", "pais", "telefone", "fax");
		Cliente cli2 = new Cliente(null, "nome1", "cargo1", "endereco1", "cidade1", "cep1", "pais1", "telefone1", "fax1");
		this.repoCliente.save(cli1);
		this.repoCliente.save(cli2);
		

		Categoria cat1 = new Categoria("Açao");
		Categoria cat2 = new Categoria("Aventura");
		Categoria cat3 = new Categoria("Comedia");
		Categoria cat4 = new Categoria("Cinema e Arte");
		Categoria cat5 = new Categoria("Terror");
		this.repoCategoria.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));

		Editora edit1 = new Editora("Globo Filmes");
		Editora edit2 = new Editora("Metro Goldwyn Mayer");
		Editora edit3 = new Editora("Paramount Motion Pictures Group");
		Editora edit4 = new Editora("21st Century Fox");
		Editora edit5 = new Editora("Universal Pictures");
		this.repoEditora.saveAll(Arrays.asList(edit1,edit2,edit3,edit4,edit5));
		
		
		Filme filme1 = new Filme("Tomates assasino", "Tomates", cat4, edit1);
		Filme filme2 = new Filme("Os Vingadores", "não sei", cat2, edit5);
		this.repoFilme.saveAll(Arrays.asList(filme1,filme2));

	}

}
