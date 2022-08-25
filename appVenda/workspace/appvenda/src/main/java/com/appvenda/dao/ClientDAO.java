package com.appvenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.appvenda.models.Client;

public class ClientDAO {
	private EntityManager entityManager;
	
	public ClientDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void salvarCliente(Client cliente) {
		getEntityManager().persist(cliente);
	}
	
	public Client alterarCliente(Client cliente) {
		return getEntityManager().merge(cliente);
	}
	
	public void excluirCliente(Long id) {
		Client cliente = consultaClienteId(id);
		getEntityManager().remove(cliente);;
	}
	
	public Client consultaClienteId(Long id) {
		return getEntityManager().find(Client.class, id);
	}
	public List<Client> listaCliente() {
		
		List<Client> clientes = new ArrayList<Client>();
		//Query query = getEntityManager().createQuery("SELECT c FROM Client c");
		
		
		TypedQuery<Client> query = getEntityManager().createQuery("SELECT c FROM Client c",Client.class);
		
		
		clientes = query.getResultList();
		return clientes;
	}
	
	public List<Client> listaClienteNome(String nome) {
		
		List<Client> clientes = new ArrayList<Client>();
		//Query query = getEntityManager().createQuery("SELECT c FROM Client c");
		
		
		TypedQuery<Client> query = getEntityManager().createQuery("SELECT c FROM Client c WHERE c.nome = :nome",Client.class);
		
		query.setParameter("nome", nome);
		
		clientes = query.getResultList();
		return clientes;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
