package com.appvendas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.appvendas.models.Usuario;

public class UsuarioDAO {

private EntityManager entityManager;
	

	public UsuarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void salvarUsuario(Usuario usuario) {
		getEntityManager().persist(usuario);
	}
	
	public Usuario alterarUsuario(Usuario usuario) {
		return getEntityManager().merge(usuario);
	}
	
	
	public void excluirUsuario(Long id) {
		Usuario usuario = consultaUsuarioId(id);
		getEntityManager().remove(usuario);
	}
	
	public Usuario consultaUsuarioId(Long id) {
		return getEntityManager().find(Usuario.class,id);
	}
	
	
	public List<Usuario> listaUsuario(){
		List<Usuario> usuarios = new ArrayList<>();
		TypedQuery<Usuario> query = getEntityManager()
				.createQuery("SELECT c FROM Usuario c",Usuario.class);
		usuarios = query.getResultList();
		return usuarios;
	}
	
	public List<Usuario> listaUsuarioNome(String nome){
		List<Usuario> usuarios = new ArrayList<>();
		TypedQuery<Usuario> query = getEntityManager()
				.createQuery("SELECT c FROM Usuario c WHERE c.username =:nome ",Usuario.class);
		query.setParameter("nome", nome);
		usuarios = query.getResultList();
		return usuarios;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}	
	
}
