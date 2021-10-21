package br.com.StartHair;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.StartHair.model.Cliente;

public class Teste {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("StartHair");
	
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		
		String jpql = "select c from Cliente c";
		TypedQuery<Cliente> typedQuery = entityManager.createQuery(jpql, Cliente.class);
		List<Cliente> listaCliente = typedQuery.getResultList();
		
		
		for(Cliente cliente: listaCliente) {
			System.out.println(cliente.getNome());
		}
		
//		int idCliente = 10;
//		String jpql = "select c from Cliente c where id = :idCliente";
//		TypedQuery<Cliente> typedQuery = entityManager.createQuery(jpql, Cliente.class).setParameter("idCliente", idCliente);
//											
//		List<Cliente> listaCliente = typedQuery.getResultList();
//		
//		
//		for(Cliente cliente: listaCliente) {
//			System.out.println(cliente.getNome());
//		}
		
//		Cliente cliente = new Cliente();
//		
//		cliente.setId(1);
//		cliente.setNome("Carlos");
//		entityManager.getTransaction().begin();;
//		entityManager.merge(cliente);
//		entityManager.getTransaction().commit();
//		
//		cliente = entityManager.find(Cliente.class, 1);
//		
		entityManagerFactory.close();
		entityManager.close();
	}
	
}
