package br.com.StartHair.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.StartHair.util.JPAUtil;

public class GenericDAO<E> {
	
	
	public void salvar(E entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		em.getTransaction().begin();
		em.persist(entidade);
		em.flush();
		em.getTransaction().commit();
		
	}
	
	public List<E> getListEntity(Class<E> entidade){
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		em.getTransaction().begin();
		
		List<E> retorno = em.createQuery("from " + entidade.getName()).getResultList();
		
		em.getTransaction().commit();
		return retorno;
	}
}
