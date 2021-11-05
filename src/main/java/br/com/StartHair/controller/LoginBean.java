package br.com.StartHair.controller;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean {
	
private String login;
private String senha;


public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
	


}
