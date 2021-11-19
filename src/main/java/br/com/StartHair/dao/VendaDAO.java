package br.com.StartHair.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.StartHair.model.Agendamento;
import br.com.StartHair.model.Cliente;
import br.com.StartHair.model.Venda;
import br.com.StartHair.util.JPAUtil;

public class VendaDAO {

	private EntityManager em = JPAUtil.getEntityManager();

	public void cadastrar(Venda venda) {
		em.getTransaction().begin();
		this.em.persist(venda);
		em.flush();
		em.getTransaction().commit();
	}

	public void atualizar(Venda venda) {
		this.em.merge(venda);
	}

	public void remover(Venda venda) {
		venda = this.em.merge(venda);
		this.em.remove(venda);
	}

	public Venda buscarPorId(Integer id) {
		return em.find(Venda.class, id);
	}

	public Venda buscarPorCliente(Cliente cliente) {
		return em.find(Venda.class, cliente);
	}

	public Venda buscarPorData(LocalDateTime data_pedido) {
		return em.find(Venda.class, data_pedido);
	}

}
