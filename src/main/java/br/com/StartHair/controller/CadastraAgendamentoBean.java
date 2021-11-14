package br.com.StartHair.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.dao.AgendamentoDAO;
import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.dao.GenericDAO;
import br.com.StartHair.model.Agendamento;
import br.com.StartHair.model.Cliente;

@Named(value="cadastraAgendamentoBean")
@SessionScoped
public class CadastraAgendamentoBean implements Serializable {

	private Cliente cliente = new Cliente();
	private Agendamento agendamento = new Agendamento();
	private GenericDAO<Agendamento> generic = new GenericDAO<Agendamento>();
	private AgendamentoDAO agendamentoDAO ;
	private ClienteDAO clienteDAO; 
	 private List<Agendamento> agendamentos = new ArrayList<Agendamento>();
	
	public String agendar(){
		
		this.clienteDAO = new ClienteDAO();
		
		cliente=clienteDAO.buscarPorId(1);
		
		this.agendamentoDAO = new AgendamentoDAO();
		agendamento.setCliente(cliente);
		agendamentoDAO.cadastrar(agendamento);
		agendamento = new Agendamento();
		listarAgendamentos();
		
		return "";
	}
	
public String salvar() {
	this.clienteDAO = new ClienteDAO();
	
	cliente=clienteDAO.buscarPorId(1);
	agendamento.setCliente(cliente);
	generic.salvar(agendamento);
	agendamento = new Agendamento();
	listarAgendamentos();
	return "";
}
	
public void listarAgendamentos() {
	 agendamentos = generic.getListEntity(Agendamento.class);
	
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


	public GenericDAO<Agendamento> getGeneric() {
		return generic;
	}

	public void setGeneric(GenericDAO<Agendamento> generic) {
		this.generic = generic;
	}

public List<Agendamento> getAgendamentos() {
	return agendamentos;
}

public void setAgendamentos(List<Agendamento> agendamentos) {
	this.agendamentos = agendamentos;
}
	
	
}
