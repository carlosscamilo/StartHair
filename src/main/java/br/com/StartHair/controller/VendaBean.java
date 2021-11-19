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

	public String realizaVenda() {
		this.vendaDAO = new VendaDAO();
		vendaDAO.cadastrar(venda);
		return "";
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public VendaDAO getVendaDAO() {
		return vendaDAO;
	}

	public void setVendaDAO(VendaDAO vendaDAO) {
		this.vendaDAO = vendaDAO;
	}

}
