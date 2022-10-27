package com.appvendas.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.appvendas.config.Page;
import com.appvendas.dao.ClienteDAO;
import com.appvendas.models.Cliente;
import com.appvendas.persistencia.ConexaoBancoDados;

public class ClienteService2 {
     
	@PersistenceContext(unitName="appvendas")
	private final EntityManager entityManager;
	
	private ClienteDAO dao;
	
	private EntityTransaction tx;
	
	public ClienteService2() {
		entityManager = ConexaoBancoDados.getConexao().getEntityManager();
		dao = new ClienteDAO(entityManager);
	}

	public void salvarCliente(Cliente cliente) {
		
		tx = getEntityManager().getTransaction();
		try {
		   getTx().begin();
		   getDao().incluir(cliente);
		   getTx().commit();
		}catch(Exception e) {
			e.printStackTrace();
			if (getTx().isActive()) {
				getTx().rollback();
			}
		}finally {
			getEntityManager().close();
		}
	}
	
	public Cliente alterarCliente(Cliente cliente) {
		tx = getEntityManager().getTransaction();
		try {
		   getTx().begin();
		   Cliente clienteAtual = getDao().alterar(cliente);
		   getTx().commit();
		   return clienteAtual;
		}catch(Exception e) {
			e.printStackTrace();
			if (getTx().isActive()) {
				getTx().rollback();
			}
		}finally {
			getEntityManager().close();
		};
		return null;
	}
	
	
	public void excluirCliente(Long id) {
		tx = getEntityManager().getTransaction();
		try {
		   getTx().begin();
		   Cliente cliente = consultaClienteId(id);
		   getDao().excluir(cliente);
		   getTx().commit();
		}catch(Exception e) {
			e.printStackTrace();
			if (getTx().isActive()) {
				getTx().rollback();
			}
		}finally {
			getEntityManager().close();
		};
	}
	
	public Cliente consultaClienteId(Long id) {
		Cliente cliente = new Cliente();
		cliente = dao.consultarPorId(id);
		return cliente;
	}
	
	
	public List<Cliente> listaCliente(){
		return dao.listar();
	}
	
	public List<Cliente> listaClienteNome(){
		return null;
	}

	public ClienteDAO getDao() {
		return dao;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public EntityTransaction getTx() {
		return tx;
	}

	public Page<Cliente> listaPaginada(int paginaAtual, int tamanhoPagina) {
		return dao.listaPaginada(paginaAtual, tamanhoPagina);
	}

	public Page<Cliente> listaPaginada(int paginaAtual, int tamanhoPagina, String text) {
		return dao.listaPaginada(paginaAtual, tamanhoPagina, text);
	}
	
	
	
	
}
