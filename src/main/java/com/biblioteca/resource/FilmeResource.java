package com.biblioteca.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.biblioteca.model.Filme;
import com.biblioteca.repository.FilmeRepository;

@RestController
@RequestMapping(value = "/filmes")
@CrossOrigin(origins = "http://localhost:4200")
public class FilmeResource {

	@Autowired
	private FilmeRepository repository;

	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Filme filme) {
		filme.getCategoria().setIdCategoria(filme.getCategoria().getIdCategoria());
		filme.getEditora().setIdEditora(filme.getEditora().getIdEditora());
		repository.save(filme);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filme.getCodigo())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@Valid @RequestBody Filme filme) {
		repository.save(filme);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "{codigo}")
	public ResponseEntity<?> excluir(@PathVariable Integer codigo) {
		try {
			repository.deleteById(codigo);
			return ResponseEntity.ok(codigo);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Filme>> findAll() {
		List<Filme> filmes = repository.findAll();
		return ResponseEntity.ok().body(filmes);
	}

}
