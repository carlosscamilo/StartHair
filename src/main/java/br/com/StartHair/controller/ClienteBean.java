package br.com.StartHair.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.StartHair.model.Cliente;

@Named
@SessionScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Cliente cliente;
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public String adicionarEvento() {
		clientes.add(cliente);
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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
	
}
