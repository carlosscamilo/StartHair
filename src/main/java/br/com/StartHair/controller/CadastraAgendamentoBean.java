package br.com.StartHair.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.dao.AgendamentoDAO;
import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.dao.UsuarioDAO;
import br.com.StartHair.model.Agendamento;
import br.com.StartHair.model.Cliente;
import br.com.StartHair.model.Usuario;

@Named(value="cadastraAgendamentoBean")
@SessionScoped
public class CadastraAgendamentoBean implements Serializable {

	private Agendamento agendamento = new Agendamento();
	private AgendamentoDAO agendamentoDAO ;

	private Usuario usuario = new Usuario();
	private UsuarioDAO usuarioDAO;
	
	public String agendar(){
		

		this.usuarioDAO = new UsuarioDAO();
		
		usuario = usuarioDAO.buscarPorId(1);
		
		
		this.agendamentoDAO = new AgendamentoDAO();
		agendamento.setUsuario(usuario);
		agendamentoDAO.cadastrar(agendamento);
		return "";
	}


	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public AgendamentoDAO getAgendamentoDAO() {
		return agendamentoDAO;
	}

	public void setAgendamentoDAO(AgendamentoDAO agendamentoDAO) {
		this.agendamentoDAO = agendamentoDAO;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
