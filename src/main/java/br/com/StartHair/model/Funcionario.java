package br.com.StartHair.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String sexo;
	private Date data_nascimento;
	private String email;
	private String senha;
	private String telefone;
	private String endereco;
	private String cidade;
	private String estado;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Funcionario() {
		super();
	}

	public Funcionario(Integer id, String nome, String cpf, String sexo, Date data_nascimento, String email, String senha,
			String telefone, String endereco, String cidade, String estado, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.data_nascimento = data_nascimento;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.usuario = usuario;
	}

	public Funcionario(Integer id, String nome, String cpf, Date data_nascimento, String email, String senha,
			String telefone, String endereco, String cidade, String estado, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
