package br.com.StartHair.model;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String senha;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Login(String username, String senha) {
		super();
		this.username = username;
		this.senha = senha;
	}
	public Login() {
		super();
	}
	
	
	
}
