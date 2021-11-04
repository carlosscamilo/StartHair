package br.com.StartHair.controller;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.model.Cliente;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean {
	
private String login;
private String senha;

public String autenticar() {
	
	return"GO_INDEX";
	
}
	


}
