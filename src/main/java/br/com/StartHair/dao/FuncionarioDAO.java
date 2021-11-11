package br.com.StartHair.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.StartHair.model.Agendamento;
import br.com.StartHair.model.Funcionario;
import br.com.StartHair.util.JPAUtil;

public class FuncionarioDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public void cadastrar(Funcionario funcionario) {
		em.getTransaction().begin();
		this.em.persist(funcionario);
		em.flush();
		em.getTransaction().commit();
	}

	public void atualizar(Funcionario funcionario) {
		this.em.merge(funcionario);
	}

	public void remover(Funcionario funcionario) {
		funcionario = this.em.merge(funcionario);
		this.em.remove(funcionario);
	}

	public Funcionario buscarPorId(Integer id) {
		return em.find(Funcionario.class, id);
	}

	public Funcionario buscarPorNome(String nome) {
		return em.find(Funcionario.class, nome);
	}
	
	public Funcionario buscarPorEmail(String email) {
		return em.find(Funcionario.class, email);
	}
	
	public List<Funcionario> buscarFuncionarios() {
        return em.createQuery("from funcionario").getResultList();
    }
}
