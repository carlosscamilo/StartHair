package br.com.StartHair.dao;

import java.io.Serializable;

import javax.ejb.Stateful;

import br.com.StartHair.model.Cliente;



@Stateful
public class ClienteDAO<TIPO> extends DAOGenerico<Cliente> implements Serializable {

	public ClienteDAO() {
		super();
		classePersistente = Cliente.class;
	}
	
}
