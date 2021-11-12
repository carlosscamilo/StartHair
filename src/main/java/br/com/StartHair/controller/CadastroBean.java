package br.com.StartHair.controller;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.dao.ClienteDAO;
import br.com.StartHair.dao.UsuarioDAO;
import br.com.StartHair.model.Cliente;
import br.com.StartHair.model.Usuario;

@Named(value = "cadastroBean")
@SessionScoped
public class CadastroBean implements Serializable {

	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;

	private Cliente cliente = new Cliente();
	private Usuario usuario = new Usuario();
	
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

}
