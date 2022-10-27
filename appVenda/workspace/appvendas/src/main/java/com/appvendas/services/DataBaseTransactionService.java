package com.appvendas.services;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.appvendas.config.Page;
import com.appvendas.message.MessageResponse;
import com.appvendas.message.ModelResponse;
import com.appvendas.message.Response;
import com.appvendas.persistencia.ConexaoBancoDados;
import com.appvendas.services.errors.ErrosData;

public abstract class DataBaseTransactionService<T, ID> {

	@PersistenceContext(unitName="appvendas")
	private EntityManager entityManager;
	
	protected List<ErrosData> errorsData;
	protected Response response;
	protected MessageResponse<ErrosData> errorData;
	protected MessageResponse<T> messageResponse;
	protected ModelResponse<T> modelResponse;
	
	
	public EntityManager openEntityManager() {
		
		if (Objects.isNull(entityManager)) {
			entityManager = ConexaoBancoDados.getConexao().getEntityManager(); 
		}
		return entityManager;
	}
	
	public void getTransaction() {
		entityManager.getTransaction().begin();
	}
	
	public void getCommit() {
		entityManager.getTransaction().commit();
	}
	
	public boolean getAtivo() {
		return entityManager.getTransaction().isActive();
	}
	
	public void getRollback() {
		entityManager.getTransaction().rollback();
	}
	
	
	public void closeEntityManager() {
		entityManager.close();
	}
	
	
	public abstract Response incluir(T entity);
	
	public abstract Response alterar(T entity);
	
	public abstract Response excluir(T entity);
	
	public abstract Response consultaPorId(ID id);
	
	public abstract Page<T> listaPaginada(int paginaAtual, int tamanhoPagina);
	
	public abstract Page<T> listaPaginada(int paginaAtual, int tamanhoPagina, String text);

	public abstract Response validarDadosFromView(T objeto);
	
	
	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public MessageResponse<T> getMessageResponse() {
		return new MessageResponse<T>();
	}

	public void setMessageResponse(MessageResponse<T> messageResponse) {
		this.messageResponse = messageResponse;
	}

	public ModelResponse<T> getModelResponse() {
		return new ModelResponse<T>();
	}

	public void setModelResponse(ModelResponse<T> modelResponse) {
		this.modelResponse = modelResponse;
	}
	
	public Response returnErrorOrNot() {
		if (errorsData.size() > 0 ) {
			response = getErrorData().message(errorsData, "", true);
		}
		else {
			response = getErrorData().message(errorsData, "", false);
		}
		return response;
	}

	public MessageResponse<ErrosData> getErrorData() {
		return new MessageResponse<ErrosData>();
	}

	public void setErrorData(MessageResponse<ErrosData> errorData) {
		this.errorData = errorData;
	}
	
	
	
	
}
