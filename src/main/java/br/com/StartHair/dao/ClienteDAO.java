package br.com.StartHair.dao;

import javax.persistence.EntityManager;

import br.com.StartHair.model.Cliente;
import br.com.StartHair.util.JPAUtil;

public class ClienteDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public void cadastrar(Cliente cliente) {
		em.getTransaction().begin();
		this.em.persist(cliente);
		em.flush();
		em.getTransaction().commit();
	}

	public void atualizar(Cliente cliente) {
		this.em.merge(cliente);
	}

	public void remover(Cliente cliente) {
		cliente = this.em.merge(cliente);
		this.em.remove(cliente);
	}

	public Cliente buscarPorId(Integer id) {
		return em.find(Cliente.class, id);
	}

}