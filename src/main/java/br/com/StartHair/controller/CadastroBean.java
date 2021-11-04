package br.com.StartHair.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.model.Cliente;

@Named(value = "cadastroBean")
@SessionScoped
public class CadastroBean implements Serializable {

	private ClienteDAO clienteDAO;

	private Cliente cliente = new Cliente();

	public String cadastrarCliente() throws Exception {

		clienteDAO = new ClienteDAO();

		clienteDAO.cadastrar(cliente);

		System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
		clear();

		return "GO_LOGIN";
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

}
