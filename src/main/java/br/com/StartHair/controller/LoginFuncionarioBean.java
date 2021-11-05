package br.com.StartHair.controller;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.model.Login;

@Named(value="loginFuncionarioBean")
@SessionScoped
public class LoginFuncionarioBean implements Serializable {

	private Login login;
	
	public boolean autenticarAdmin() {
		
		this.login = new Login();
		
		if("admin".equals(login.getUsername())&&"admin".equals(login.getSenha())) {
			System.out.println("Validou");
			return true;
		}
		
		else {
			System.out.println("Nao validou");
			return false;
		}
		
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
}
