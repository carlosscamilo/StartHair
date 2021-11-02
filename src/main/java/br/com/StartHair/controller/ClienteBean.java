package br.com.StartHair.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import com.mysql.cj.util.Util;

import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.model.Cliente;
import br.com.StartHair.util.util;

@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

//
//	@Inject
//	private Cliente cliente;

	@EJB
	ClienteDAO<Cliente> dao;
	Cliente objeto;

	public ClienteBean() {

	}

	public String listar() {
		return "";
	}

	public void novo() {
		objeto = new Cliente();
	}
	
	public void salvar () {
		try {
			if (objeto.getId() == 0) {
				dao.persist(objeto);	
			}
			else {
				dao.merge(objeto);
			}
			util.mensagemInformacao("Objeto Persistido com Sucesso!");
		} catch (Exception ex) {
			util.mensagemErro("Erro ao persistir objeto: " + util.getMensagemErro(ex));
		}
	}

	public void alterar(Object id) {

		try {
			objeto = dao.getObjectById(id);
		}

		catch (Exception ex) {
			util.mensagemErro("Erro ao recuperar objeto: " + util.getMensagemErro(ex));
		}
	}

	public void excluir(Object id) {

		try {
			objeto = dao.getObjectById(id);
			dao.remove(objeto);
			util.mensagemInformacao("Objeto Removido");
		} catch (Exception ex) {
			util.mensagemErro("Erro ao excluir objeto: " + util.getMensagemErro(ex));
		}
	}

	public ClienteDAO<Cliente> getDao() {
		return dao;
	}

	public void setDao(ClienteDAO<Cliente> dao) {
		this.dao = dao;
	}

	public Cliente getObjeto() {
		return objeto;
	}

	public void setObjeto(Cliente objeto) {
		this.objeto = objeto;
	}

//	private List<Cliente> clientes = new ArrayList<Cliente>();
//	
//	public String adicionarEvento() {
//		clientes.add(cliente);
//		System.out.println("Evento " + cliente.getNome() + " cadastrado com sucesso!");
//		clear();
//		return "";
//	}
//	
//
//	public void clear() {
//		this.cliente = new Cliente();
//	}
//	
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
//
//	public List<Cliente> getClientes() {
//		return clientes;
//	}
//
//	public void setClientes(List<Cliente> clientes) {
//		this.clientes = clientes;
//	}
//	

}
