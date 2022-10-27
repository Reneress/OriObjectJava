package com.appvendas.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;


import com.appvendas.models.Usuario;
import com.appvendas.persistencia.ConexaoBancoDados;

public class UsuarioService {

	@PersistenceContext(unitName="appvendas")
	private final EntityManager entityManager;
	
	
	public UsuarioService() {
		System.out.println("Excutando o construtor da classe");
		entityManager = ConexaoBancoDados.getConexao().getEntityManager();
	}
	
	
	public void showConexaoBanco() {
		System.out.println("Executando showConexaoBanco >>>>");
		EntityTransaction transacao = entityManager.getTransaction();
		
		if (entityManager !=null) {
			System.out.println("banco aberto");
		}
		
		if (transacao !=null) {
			System.out.println("Conectado com o banco de dados");
		}
		
		
	}


	public void salvarUsuario(Usuario usuario) {
		System.out.println(usuario.toString());
		
		
		
	}
	
}
