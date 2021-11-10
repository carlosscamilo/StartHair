package br.com.StartHair.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="agendamento")
public class Agendamento implements Serializable {

	 
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
    private Usuario usuario;
	
    private String servico;
    @Column(unique = true)
    private LocalDateTime data_agendamento;

    
    
    public Agendamento() {
		super();
	}
    
	public Agendamento(Integer id, Usuario usuario, String servico, LocalDateTime data_agendamento) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.servico = servico;
		this.data_agendamento = data_agendamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public LocalDateTime getData_agendamento() {
		return data_agendamento;
	}

	public void setData_agendamento(LocalDateTime data_agendamento) {
		this.data_agendamento = data_agendamento;
	}
	
	
    


    
}
