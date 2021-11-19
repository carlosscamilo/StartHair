package br.com.StartHair.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.StartHair.dao.AgendamentoDAO;
import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.dao.GenericDAO;
import br.com.StartHair.model.Agendamento;
import br.com.StartHair.model.Cliente;
import br.com.StartHair.model.Usuario;

@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {
	private Cliente cliente = new Cliente();
	private ClienteDAO clienteDAO;
	private GenericDAO<Agendamento> generic = new GenericDAO<Agendamento>();
	private AgendamentoDAO agendamentoDAO;
	private Agendamento agendamento;
	private List<Agendamento> agendamentos = new ArrayList<Agendamento>() ;
	
	
	@PostConstruct
	public void listarAgendamentosCliente() {

		Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogado");
		
		agendamentos = agendamentoDAO.buscarAgendamentoCliente(u.getCliente().getId());

	}
	
	

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public AgendamentoDAO getAgendamentoDAO() {
		return agendamentoDAO;
	}

	public void setAgendamentoDAO(AgendamentoDAO agendamentoDAO) {
		this.agendamentoDAO = agendamentoDAO;
	}

	
	public GenericDAO<Agendamento> getGeneric() {
		return generic;
	}

	public void setGeneric(GenericDAO<Agendamento> generic) {
		this.generic = generic;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	
}
