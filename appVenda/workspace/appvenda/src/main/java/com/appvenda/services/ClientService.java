package com.appvenda.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import com.appvenda.dao.ClientDAO;
import com.appvenda.models.Client;
import com.appvenda.persistence.DataBaseConnection;

public class ClientService {
	
	@PersistenceContext(unitName = "appvenda")
	private final EntityManager entityManager;
	
	private ClientDAO  dao;
	private EntityTransaction tx;

	public ClientService() {
		entityManager = DataBaseConnection.getConnection().getEntityManager();
		dao = new ClientDAO(entityManager);
	}

	public void salvarCliente(Client cliente) {
		tx = getEntityManager().getTransaction();
		
		try {
			getTx().begin();
			getDao().salvarCliente(cliente);
			getTx().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			if(getTx().isActive()) {
				getTx().rollback();
			}
		}
		finally {
			getEntityManager().close();		
		}
	}
	
	public Client alterarCliente(Client cliente) {
		tx = getEntityManager().getTransaction();
		
		try {
			getTx().begin();
			Client clienteAtual = getDao().alterarCliente(cliente);
			getTx().commit();
			return clienteAtual;
		}
		catch(Exception e) {
			e.printStackTrace();
			if(getTx().isActive()) {
				getTx().rollback();
			}
		}
		finally {
			getEntityManager().close();		
		}
		return null;
	}
	
	public Client excluirCliente(Long id) {
		
		tx = getEntityManager().getTransaction();
		
		try {
			getTx().begin();
			getDao().excluirCliente(id);
			getTx().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			if(getTx().isActive()) {
				getTx().rollback();
			}
		}
		finally {
			getEntityManager().close();		
		}
		return null;
	}
	
	public Client excluirCliente() {
		
		return null;
	}
	
	public Client consultaClienteId(Long id) {
		
		Client cliente = new Client();
		cliente = dao.consultaClienteId(id);
		return cliente;
	}
	
	public List<Client> listaCliente() {
		return dao.listaCliente();
		//return null;
	}
	
	public List<Client> listaClienteNome() {
		return null;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public ClientDAO getDao() {
		return dao;
	}

	public EntityTransaction getTx() {
		return tx;
	}
	
	
}

