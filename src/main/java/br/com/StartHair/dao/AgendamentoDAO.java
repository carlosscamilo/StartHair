package br.com.StartHair.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.StartHair.model.Agendamento;
import br.com.StartHair.model.Cliente;
import br.com.StartHair.util.JPAUtil;

public class AgendamentoDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public void cadastrar(Agendamento agendamento) {
		em.getTransaction().begin();
		this.em.persist(agendamento);
		em.flush();
		em.getTransaction().commit();
	}

	public void atualizar(Agendamento agendamento) {
		this.em.merge(agendamento);
	}

	public void remover(Agendamento agendamento) {
		agendamento = this.em.merge(agendamento);
		this.em.remove(agendamento);
	}

	public Agendamento buscarPorId(Integer id) {
		return em.find(Agendamento.class, id);
	}

	public Agendamento buscarPorServico(String servico) {
		return em.find(Agendamento.class, servico);
	}
	
	public Agendamento buscarPorCliente(Cliente cliente) {
		return em.find(Agendamento.class, cliente);
	}
	
	public List<Agendamento> buscarAgendamentos() {
        return em.createQuery("from agendamento").getResultList();
    }
}
