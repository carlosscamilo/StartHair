package br.com.StartHair.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.StartHair.dao.UsuarioDAO;
import br.com.StartHair.model.Usuario;

@Named(value = "loginBean")
@ViewScoped
public class LoginBean {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String fazerLogin() {
		Usuario usuarioConsultado = usuarioDAO.buscarPorUsernameAndEmail("carlos_camilo250@hotmail.com", "carlos250");
				
		if(usuarioConsultado!= null && usuarioConsultado.getCliente() != null) {
			return "GO_INDEX";
		}else if(usuarioConsultado!= null && usuarioConsultado.getFuncionario() != null) {
			return "TELA_FUNCAO";
		}
		
		usuario = new Usuario();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario nao encontrado!", "Erro no Login"));
		return null;	

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



}
