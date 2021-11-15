package br.com.StartHair.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.dao.GenericDAO;
import br.com.StartHair.dao.UsuarioDAO;
import br.com.StartHair.model.Cliente;
import br.com.StartHair.model.Usuario;

@Named(value = "cadastroBean")
@SessionScoped
public class CadastroBean implements Serializable {

	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;
	private GenericDAO<Cliente> generic = new GenericDAO<Cliente>();
	
	private Cliente cliente = new Cliente();
	private Usuario usuario = new Usuario();
	 private List<Cliente> clientes = new ArrayList<Cliente>();
	 private Map clienteItem=null;
		private ListDataModel model; 
	
	public String cadastrarCliente() throws Exception {

		this.clienteDAO = new ClienteDAO();
		this.usuarioDAO = new UsuarioDAO();
		
		usuario.setUsername(cliente.getEmail());
		usuario.setPassword(cliente.getSenha());
		usuario.setCliente(cliente);
		cliente.setUsuario(usuario);

//		Usuario u = usuarioDAO.buscarPorUsernameAndEmail("Lenore@gmail.com", "123");
//		System.out.println(u);
		
		clienteDAO.cadastrar(cliente);
		//usuarioDAO.cadastrar(usuario);

		System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
		
		System.out.println("Usuario " + usuario.getUsername() + 
		" ," + usuario.getPassword() + 
		", " + usuario.getCliente() +
		" cadastrado com sucesso!");
		
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
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
