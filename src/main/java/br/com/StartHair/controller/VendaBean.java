package br.com.StartHair.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.dao.AgendamentoDAO;
import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.dao.VendaDAO;
import br.com.StartHair.model.Cliente;
import br.com.StartHair.model.Venda;

@Named(value = "vendaBean")
@SessionScoped
public class VendaBean implements Serializable {

	private Venda venda = new Venda();
	private VendaDAO vendaDAO;

	private Cliente cliente = new Cliente();
	private ClienteDAO clienteDAO;

	public String realizaVenda() {

		
		this.clienteDAO = new ClienteDAO();
		cliente = clienteDAO.buscarPorId(1);
		
		this.vendaDAO = new VendaDAO();
		//Gambiarra pra setar o cliente
		venda.setCliente(cliente);
		vendaDAO.cadastrar(venda);

		
		
		return "";
	}

}
