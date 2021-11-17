package br.com.StartHair.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity(name = "agendamento")
@Table(name="agendamento")
public class Agendamento implements Serializable {

	 
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
	  @Column
    private String servico;
    @Column(unique = true)
    private LocalDateTime data_agendamento;
    @Transient
    private transient boolean editing;

    
    
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

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", cliente=" + cliente + ", servico=" + servico + ", data_agendamento="
				+ data_agendamento + "]";
	}

	
	
    


    
}
