package com.appvendas.services;

import java.util.ArrayList;

import com.appvendas.config.Page;
import com.appvendas.dao.ClienteDAO;
import com.appvendas.message.Response;
import com.appvendas.models.Cliente;
import com.appvendas.services.errors.ErrosData;
import com.appvendas.services.errors.TestarCampoRequerido;

public class ClienteService extends DataBaseTransactionService<Cliente, Long>{
	
	private ClienteDAO dao;
	
	public ClienteService() {
		dao = new ClienteDAO(openEntityManager());
	}

	@Override
	public Response incluir(Cliente cliente) {
		try {
			getTransaction();
			dao.incluir(cliente);
			getCommit();
		    response = getMessageResponse().message(cliente, "Registro cadastrado com sucesso!", false);	
		} catch (Exception e) {
			e.printStackTrace();
			if (getAtivo()) {
				getRollback();
			}
		    response = getMessageResponse().message(cliente, e.getMessage(), true);	
		} finally {
			closeEntityManager();
		}
		return response;
		
	}

	@Override
	public Response alterar(Cliente cliente) {
		try {
			getTransaction();
			cliente = dao.alterar(cliente);
			getCommit();
			response = getMessageResponse().message(cliente, "Registro cadastrado com sucesso!", false);	
		} catch (Exception e) {
			e.printStackTrace();
			if (getAtivo()) {
				getRollback();
			}
			response = getMessageResponse().message(cliente, e.getMessage(), true);	
		} finally {
			closeEntityManager();
		}
		return response;
	}

	@Override
	public Response excluir(Cliente cliente) {
		try {
			getTransaction();
			Cliente clienteCadastrado = dao.consultarPorId(cliente.getId());
			dao.excluir(clienteCadastrado);
			getCommit();
			response = getMessageResponse().message(cliente, "Registro excluído com sucesso!", false);	
		} catch (Exception e) {
			e.printStackTrace();
			if (getAtivo()) {
				getRollback();
			}
			response = getMessageResponse().message(cliente, e.getMessage(), true);	
		} finally {
			closeEntityManager();
		}
		return response;
	}

	@Override
	public Response consultaPorId(Long id) {
		Cliente cliente = null;
		try {
			cliente = dao.consultarPorId(id);
			response = getMessageResponse().message(cliente, "Registro localizado com sucesso!", false);	
		} catch (Exception e) {
			e.printStackTrace();
			response = getMessageResponse().message(cliente, e.getMessage(), true);	
		} finally {
			closeEntityManager();
		}
		return response;
	}

	@Override
	public Page<Cliente> listaPaginada(int paginaAtual, int tamanhoPagina) {
		return dao.listaPaginada(paginaAtual, tamanhoPagina);
	}

	@Override
	public Page<Cliente> listaPaginada(int paginaAtual, int tamanhoPagina, String text) {
		return dao.listaPaginada(paginaAtual, tamanhoPagina, text);
	}

	@Override
	public Response validarDadosFromView(Cliente cliente) {
		errorsData = new ArrayList<ErrosData>();
		errorsData = TestarCampoRequerido.validarCampoRequerido(cliente);
		
		return returnErrorOrNot();
	}

	
	
	
	
}
