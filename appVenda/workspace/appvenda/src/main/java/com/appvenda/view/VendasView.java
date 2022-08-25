package com.appvenda.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.appvenda.models.Client;
import com.appvenda.services.ClientService;

public class VendasView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2848604308078518244L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendasView frame = new VendasView();
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
	public VendasView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		excluirClient();
	}
	
	public void salvarClient() {
		ClientService clienteService = new ClientService();
		Client cliente = new Client();
		
		cliente.setName("Leonardo Reneres dos Santos 1");
		cliente.setAddress("Rua Tokuji Tokunaga, 721");
		cliente.setDistrict("Quemil");
		cliente.setIdade(20);
		cliente.setEmail("leonardoreneres525@gmail.com");
		cliente.setCep("16-202-250");
		cliente.setTelefone("18-991271959");
		
		clienteService.salvarCliente(cliente);
	}
	
	public void alterarClient() {
		ClientService clienteService = new ClientService();
		Client cliente = new Client();
		Client clienteCadastrado = new Client();
		
		clienteCadastrado = clienteService.consultaClienteId(2L);
		System.out.println(clienteCadastrado.toString());
		
		cliente.setId(clienteCadastrado.getId());
		cliente.setName(clienteCadastrado.getName());
		cliente.setAddress(clienteCadastrado.getAddress());
		cliente.setDistrict(clienteCadastrado.getDistrict());
		cliente.setIdade(clienteCadastrado.getIdade());
		cliente.setEmail(clienteCadastrado.getEmail());
		cliente.setCep(clienteCadastrado.getCep());
		cliente.setTelefone(clienteCadastrado.getTelefone());
		
		
		System.out.println(cliente.toString());
		
		cliente.setName("Leonardo Reneres");
		
		clienteService.alterarCliente(cliente);
	}
	
	public void excluirClient() {
		ClientService clienteService = new ClientService();
		Long id = 1L;
		
		Client cliente = new Client();
		
		cliente = clienteService.consultaClienteId(id);
		
		System.out.println(cliente.toString());
		
		clienteService.excluirCliente(cliente.getId());
		
	}

}
