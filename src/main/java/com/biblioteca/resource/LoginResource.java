package com.biblioteca.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
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

import com.biblioteca.model.Login;
import com.biblioteca.repository.LoginRepository;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "${porta.angular}")
public class LoginResource {

	@Autowired
	private LoginRepository repository;
	private Login user;

	@PostMapping
	public ResponseEntity<?> login(@Valid @RequestBody Login login) {
		user = repository.findByEmail(login.getEmail());
		
		if(user == null) {
			//Login loginRetorno = new Login(login.getEmail(), login.getSenha(), "Não encontrado usuario para o email informado");			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else if(user.getEmail().equals(login.getEmail()) && !user.getSenha().equals(login.getSenha())) {
			//Login loginRetorno = new Login(login.getEmail(), login.getSenha(), "Senha incorreta!");			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		user.setMsgUsuario("Usuario Logado com Sucesso");
		System.err.println("Usuario retorno : "+ user);
		return  ResponseEntity.ok().build();
	}

}
