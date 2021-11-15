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
	
	public E merge(E entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		em.getTransaction().begin();
		em.persist(entidade);
	E retorno = em.merge(entidade);
		em.getTransaction().commit();
		return retorno;
	}
	
	
	public void deletePorId(E entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		em.getTransaction().begin();
		
		Object id = JPAUtil.getPrimaryKey(entidade);
		em.createQuery("delete from " + entidade.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
		
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
