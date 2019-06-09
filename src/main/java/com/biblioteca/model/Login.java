package com.biblioteca.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	private String email;
	private String senha;
	private String msgUsuario;
	
	

	public void setMsgUsuario(String msgUsuario) {
		this.msgUsuario = msgUsuario;
	}
	public Login() {
		super();
	}

	public Login(String email, String senha, String msgUsuario) {
		super();
		this.email = email;
		this.senha = senha;
		this.msgUsuario = msgUsuario;
	}
	//get e set

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMsgUsuario() {
		return msgUsuario;
	}

}
