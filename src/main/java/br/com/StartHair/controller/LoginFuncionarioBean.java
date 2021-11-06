package br.com.StartHair.controller;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.model.Login;

@Named(value="loginFuncionarioBean")
@SessionScoped
public class LoginFuncionarioBean implements Serializable {

	private Login login = new Login();
	
	public String autenticarAdmin() {
		
		
		if("admin".equals(login.getUsername())&&"admin".equals(login.getSenha())) {
			System.out.println("Validou");
			return "Validado";
		}
		
		else {
			System.out.println("Nao validou");
			return "Nao validado";
		}
		
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
}
