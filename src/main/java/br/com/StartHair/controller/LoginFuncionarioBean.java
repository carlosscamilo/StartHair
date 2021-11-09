package br.com.StartHair.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.StartHair.model.Login;


@Named
@SessionScoped
public class LoginFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Login login;
	
	private List<Login> logins = new ArrayList<Login>();
	
	public String autenticarAdmin() {
		if("admin".equals(login.getUsername())&&"admin".equals(login.getSenha())) {
			System.out.println("Validou");
			return "GO_CADFUNCIONARIO";
		}
		
		else {
			System.out.println("Não validou");
			return "Não validou";
			
		}
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	

	public void clear() {
		this.login = new Login();
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}
	
	
	
	
}
