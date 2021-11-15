package br.com.StartHair.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.StartHair.model.Cliente;
import br.com.StartHair.util.JPAUtil;

public class ClienteDAO {

	private EntityManager em = JPAUtil.getEntityManager();
	private Query query;
	
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

	public Cliente buscarPorNome(String nome) {
		return em.find(Cliente.class, nome);
	}
	
	public Cliente buscarPorEmail(String email) {
		return em.find(Cliente.class, email);
	}
	
	public List<Cliente> buscarClientes() {
        return em.createQuery("from cliente").getResultList();
    }
	
	
}