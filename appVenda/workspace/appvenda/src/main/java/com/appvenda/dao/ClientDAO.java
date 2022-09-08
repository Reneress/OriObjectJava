package com.appvenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.appvenda.config.Page;
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

	public Page<Client> listaPaginada(int paginaAtual, int tamanhoPagina) {
		
		Page<Client> page = new Page<Client>();
		
		List<Client> listaCliente = new ArrayList<>();
		
		Integer total =count().intValue();
		
		TypedQuery<Client> query = getEntityManager().createQuery("SELECT c from Client c",Client.class);
		
		listaCliente = query.setFirstResult(paginaAtual).setMaxResults(tamanhoPagina).getResultList();
		
		page.setContent(listaCliente);
		page.setPage(paginaAtual);
		page.setPageSize(tamanhoPagina);
		page.setTotalRecords(total);
		page.setTotalPage(total/tamanhoPagina);
		
				
		return page;
	}
	
	public Long count() {
		TypedQuery<Long> query = getEntityManager().createQuery("SELECT COUNT(c) from Client c",Long.class);
		
		long total = query.getSingleResult();
		return total;
	}

}
