package br.com.StartHair.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.StartHair.model.Usuario;
import br.com.StartHair.util.JPAUtil;

public class UsuarioDAO {

	private EntityManager em = JPAUtil.getEntityManager();
	
	public Usuario buscarPorUsernameAndEmail(String username, String password) {
		String jqpl = "SELECT u FROM Usuario u WHERE u.username = :username and u.password = :password";
		
	try { 	
		 return  em.createQuery(jqpl, Usuario.class)
				 .setParameter("username", username)
				 .setParameter("password", password)
				 .getSingleResult();

	}catch (NoResultException e) {
        return null;
  }
	}

	public void cadastrar(Usuario usuario) {
		em.getTransaction().begin();
		this.em.persist(usuario);
		em.flush();
		em.getTransaction().commit();
	}

	public void atualizar(Usuario usuario) {
		this.em.merge(usuario);
	}

	public void remover(Usuario usuario) {
		usuario = this.em.merge(usuario);
		this.em.remove(usuario);
	}

	public Usuario buscarPorId(Integer id) {
		return em.find(Usuario.class, id);
	}

	public Usuario buscarPorNome(String nome) {
		return em.find(Usuario.class, nome);
	}
	
	public Usuario buscarPorEmail(String email) {
		return em.find(Usuario.class, email);
	}
	
	
}
