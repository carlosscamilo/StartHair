package br.com.StartHair.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.dao.AgendamentoDAO;
import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.model.Agendamento;
import br.com.StartHair.model.Cliente;

@Named(value="cadastraAgendamentoBean")
@SessionScoped
public class CadastraAgendamentoBean implements Serializable {

	private Cliente cliente = new Cliente();
	private Agendamento agendamento = new Agendamento();
	private AgendamentoDAO agendamentoDAO ;
	private ClienteDAO clienteDAO; 
	public String agendar(){
		
		this.clienteDAO = new ClienteDAO();
		
		cliente=clienteDAO.buscarPorId(1);
		
		this.agendamentoDAO = new AgendamentoDAO();
		agendamento.setCliente(cliente);
		agendamentoDAO.cadastrar(agendamento);
		return "";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	
	
	
}
