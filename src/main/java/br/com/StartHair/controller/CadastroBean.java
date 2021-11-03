package br.com.StartHair.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.model.Cliente;

@Named(value = "clienteBean")
@SessionScoped
public class CadastroBean implements Serializable {
	
	private ClienteDAO clienteDAO;
	
	private Cliente cliente = new Cliente();

	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	public String adicionarEvento() throws Exception {
		
		clienteDAO = new ClienteDAO();
	
		clienteDAO.cadastrar(cliente);
		
		listaCliente.add(cliente);
		System.out.println("Evento " + cliente.getNome() + " cadastrado com sucesso!");
		clear();
		
		return "";
	}
	
	public void clear() {
		this.cliente = new Cliente();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getlistaCliente() {
		return listaCliente;
	}

	public void setlistaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
}
