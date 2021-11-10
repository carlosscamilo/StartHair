package br.com.StartHair.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.StartHair.dao.FuncionarioDAO;
import br.com.StartHair.dao.UsuarioDAO;
import br.com.StartHair.model.Funcionario;
import br.com.StartHair.model.Usuario;

@Named
@SessionScoped
public class CadastrarFuncionarioBean implements Serializable {

	private Funcionario funcionario = new Funcionario();
	private FuncionarioDAO funcionarioDAO;
	private Usuario usuario = new Usuario();
	private UsuarioDAO usuarioDAO;

	public String cadastrarFuncionario() throws Exception {

		this.funcionarioDAO = new FuncionarioDAO();
		this.usuarioDAO = new UsuarioDAO();

		usuario.setUsername(funcionario.getEmail());
		usuario.setPassword(funcionario.getSenha());
		usuario.setFuncionario(funcionario);
		funcionario.setUsuario(usuario);
//	Usuario u = usuarioDAO.buscarPorUsernameAndEmail("Lenore@gmail.com", "123");
//	System.out.println(u);

		funcionarioDAO.cadastrar(funcionario);
//		usuarioDAO.cadastrar(usuario);

		System.out.println("Funcionario " + funcionario.getNome() + " cadastrado com sucesso!");

		System.out.println("Usuario " + usuario.getUsername() + " ," + usuario.getPassword() + ", "
				+ usuario.getFuncionario() + " cadastrado com sucesso!");

		clear();

		return "IR_LOGIN";
	}

	public void clear() {
		this.funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


}
