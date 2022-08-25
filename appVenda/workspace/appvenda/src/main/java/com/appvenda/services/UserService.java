package com.appvenda.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.appvenda.dao.UserDAO;
import com.appvenda.models.User;
import com.appvenda.persistence.DataBaseConnection;

public class UserService {
	
	@PersistenceContext(unitName = "appvenda")
	private final EntityManager entityManager;
	
	public UserService() {
		System.out.println("Executing the class UserService constructor");
		entityManager = DataBaseConnection.getConnection().getEntityManager();
	}
	
	public void showDataBaseConnection() {
		System.out.println("Executing showDataBaseConnection() in UserService");
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		if(entityManager != null ) {
			System.out.println("Connected with dataBase");
		}
		
		if(transaction != null ) {
			System.out.println("Connected with dataBase");
		}
	}
	
	public void saveUser(User user) {
		System.out.println(user.toString());
		UserDAO dao = new UserDAO(entityManager);
		dao.saveUser(user);
	}
}
