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
@Entity(name = "agendamento")
@Table(name="agendamento")
public class Agendamento implements Serializable {

	 
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
    private Cliente cliente;
	
    private String servico;
    @Column(unique = true)
    private LocalDateTime data_agendamento;

    
    
    public Agendamento() {
		super();
	}
    
	public Agendamento(Integer id, Cliente cliente, String servico, LocalDateTime data_agendamento) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.servico = servico;
		this.data_agendamento = data_agendamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
