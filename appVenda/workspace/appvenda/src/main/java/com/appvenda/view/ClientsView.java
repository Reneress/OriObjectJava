package com.appvenda.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.appvenda.models.User;
import com.appvenda.services.UserService;

@SuppressWarnings("serial")
public class ClientsView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientsView frame = new ClientsView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		dataBaseConnection();
		saveUser();
	}
	
	private void saveUser() {
		User user = new User();
		UserService userService = new UserService();
		user.setUsername("Leonardo Reneres dos Santos");
		user.setEmail("reneres.s@aluno.ifsp.edu.br");
		user.setPassword("12345");
		user.setConfirm("12345");
		user.setActive(true);
		
		userService.saveUser(user);
	}
	
	

	public void dataBaseConnection() {
		System.out.println("Connecting database on ClientsView");
		UserService userService = new UserService();
		userService.showDataBaseConnection();
	}
	
	
}
