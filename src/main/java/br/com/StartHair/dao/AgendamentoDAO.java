package br.com.StartHair.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.StartHair.model.Agendamento;
import br.com.StartHair.model.Cliente;
import br.com.StartHair.model.Usuario;
import br.com.StartHair.util.JPAUtil;

public class AgendamentoDAO {

	private EntityManager em = JPAUtil.getEntityManager();
	private Query query;

	public void cadastrar(Agendamento agendamento) {
		em.getTransaction().begin();
		this.em.persist(agendamento);
		em.flush();
		em.getTransaction().commit();
	}

	public void atualizar(Agendamento agendamento) {
		em.getTransaction().begin();
		this.em.merge(agendamento);
		em.flush();
		em.getTransaction().commit();
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

	public List<Agendamento> buscarAgendamentoCliente(Integer id) {
		
		String jqpl = "SELECT a FROM agendamento a WHERE a.cliente_id = :cliente_id";
		
		return (List<Agendamento>) em.createQuery(jqpl, Agendamento.class).setParameter("cliente_id", id)
		.getSingleResult();
		
		  

		
		
	}


	public List<Agendamento> getListEntityClienteAgendamento(Class<Agendamento> agendamento) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		em.getTransaction().begin();

		
		
		List<Agendamento> retorno = em.createQuery("from " + agendamento).getResultList();

		em.getTransaction().commit();
		return retorno;
	}
	
}
