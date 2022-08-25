package com.appvenda.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.appvenda.models.Client;
import com.appvenda.services.ClientService;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class VendasView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2848604308078518244L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCEP;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtIdade;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 51, 800, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(41, 39, 79, 26);
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(130, 39, 363, 26);
		txtNome.setBorder(null);
		txtNome.setFont(new Font("Verdana", Font.PLAIN, 20));
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblEndereco.setBounds(10, 82, 110, 26);
		panel.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtEndereco.setColumns(10);
		txtEndereco.setBorder(null);
		txtEndereco.setBounds(130, 82, 363, 26);
		panel.add(txtEndereco);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblBairro.setBounds(41, 133, 79, 26);
		panel.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtBairro.setColumns(10);
		txtBairro.setBorder(null);
		txtBairro.setBounds(130, 133, 363, 26);
		panel.add(txtBairro);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setAutoscrolls(true);
		lblCEP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCEP.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCEP.setBounds(10, 176, 110, 26);
		panel.add(lblCEP);
		
		txtCEP = new JTextField();
		txtCEP.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtCEP.setColumns(10);
		txtCEP.setBorder(null);
		txtCEP.setBounds(130, 176, 363, 26);
		panel.add(txtCEP);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblEmail.setBounds(10, 220, 110, 26);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(130, 220, 363, 26);
		panel.add(txtEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblTelefone.setBounds(10, 271, 110, 26);
		panel.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtTelefone.setColumns(10);
		txtTelefone.setBorder(null);
		txtTelefone.setBounds(130, 271, 363, 26);
		panel.add(txtTelefone);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdade.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblIdade.setAutoscrolls(true);
		lblIdade.setBounds(10, 314, 110, 26);
		panel.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtIdade.setColumns(10);
		txtIdade.setBorder(null);
		txtIdade.setBounds(130, 314, 363, 26);
		panel.add(txtIdade);
		//salvarClient();
		//alterarClient();
		//excluirClient():
		//consultaClient();
		//listarClient();
	}
	
	public void salvarClient() {
		ClientService clienteService = new ClientService();
		Client cliente = new Client();
		
		cliente.setName(txtNome.getText());
		cliente.setAddress(txtEndereco.getText());
		cliente.setDistrict(txtBairro.getText());
		cliente.setIdade(Integer.parseInt(txtIdade.getText()));
		cliente.setEmail(txtEmail.getText());
		cliente.setCep(txtCEP.getName());
		cliente.setTelefone(txtTelefone.getText());
		
		clienteService.salvarCliente(cliente);
	}
	
	public void alterarClient() {
		ClientService clienteService = new ClientService();
		Client cliente = new Client();
		Client clienteCadastrado = new Client();
		
		clienteCadastrado = clienteService.consultaClienteId(2L);
		System.out.println(clienteCadastrado.toString());
		
		txtNome.setText(clienteCadastrado.getName());
		txtEndereco.setText(clienteCadastrado.getAddress());
		
		/*cliente.setId(clienteCadastrado.getId());
		cliente.setName(clienteCadastrado.getName());
		cliente.setAddress(clienteCadastrado.getAddress());
		cliente.setDistrict(clienteCadastrado.getDistrict());
		cliente.setIdade(clienteCadastrado.getIdade());
		cliente.setEmail(clienteCadastrado.getEmail());
		cliente.setCep(clienteCadastrado.getCep());
		cliente.setTelefone(clienteCadastrado.getTelefone());
		
		
		System.out.println(cliente.toString());
		*/
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
	
	public void consultaClient() {
		ClientService clienteService = new ClientService();
		Client cliente = new Client();
		
		Long id = 2L;
		
		cliente = clienteService.consultaClienteId(id);
		
		System.out.println(cliente.toString());
	}
	
	public void listarClient() {
		ClientService clienteService = new ClientService();
				
		List<Client> clientes = new ArrayList<>();
		clientes = clienteService.listaCliente();
		
		for(Client cliente: clientes) {
			System.out.println(cliente.toString());
		}
	}
}
