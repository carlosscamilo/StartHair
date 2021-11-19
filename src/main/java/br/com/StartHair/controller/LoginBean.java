package br.com.StartHair.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.StartHair.dao.UsuarioDAO;
import br.com.StartHair.model.Usuario;
import br.com.StartHair.util.SessionContext;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String fazerLogin() {
		Usuario usuarioConsultado = usuarioDAO.buscarPorUsernameAndEmail(usuario.getUsername(), usuario.getPassword());

		if (usuarioConsultado == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario nao encontrado!", "Erro no Login"));
			return null;
		} else if (usuarioConsultado.getCliente() != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuarioConsultado);
			System.out.println("Cliente");
			return "TELA_CLI";
		} else if (usuarioConsultado.getFuncionario() != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuarioConsultado);
			System.out.println("Funcionario");
			return "GO_INDEX";
		}
		return "Usuario Logado";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index_login";
	}
	public String logoutCli() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "indexCli_login";
	}
}
