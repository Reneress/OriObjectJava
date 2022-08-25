package com.appvenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//import com.appvenda.models.Client;
import com.appvenda.models.User;

public class UserDAO {
	private EntityManager entityManager;
	public void saveUser (User user) {
		System.out.println("Saving on dataBase the user: "+user.toString());
	}
	
	public UserDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void salvarUser(User User) {
		getEntityManager().persist(User);
	}
	
	public User alterarUser(User User) {
		return getEntityManager().merge(User);
	}
	
	public void excluirUser(Long id) {
		User User = consultaUserId(id);
		getEntityManager().remove(User);;
	}
	
	public User consultaUserId(Long id) {
		return getEntityManager().find(User.class, id);
	}
	public List<User> listaUser() {
		
		List<User> Users = new ArrayList<User>();
			
		
		TypedQuery<User> query = getEntityManager().createQuery("SELECT u FROM User u",User.class);
		
		
		Users = query.getResultList();
		return Users;
	}
	
	public List<User> listaUserNome(String nome) {
		
		List<User> Users = new ArrayList<User>();
				
		TypedQuery<User> query = getEntityManager().createQuery("SELECT u FROM User u WHERE u.username = :nome",User.class);
		
		query.setParameter("nome", nome);
		
		Users = query.getResultList();
		return Users;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
}
