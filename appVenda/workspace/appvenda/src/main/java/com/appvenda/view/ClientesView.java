package com.appvenda.view;

//import java.awt.BorderLayout;
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
//import javax.swing.JSeparator;
//import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.beans.EventHandler;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientesView extends JFrame {

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
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	private Long idCliente = 0l;
	private ClientService clienteService;
	
	private Client cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesView frame = new ClientesView();
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
	public ClientesView() {
		
		initComponentes();
		EventHandler();
		
		consultaClient();
	}
	
	private void EventHandler() {
		// TODO Auto-generated method stub
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idCliente == 0L) {
					salvarClient();
				}
				else{
					alterarClient();
				}
			}
		});
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	public void salvarClient() {
		
		clienteService = getClienteService();
		cliente = getCliente();
		
		setClienteFromView();
		clienteService.salvarCliente(cliente);
		

		limpa();
	}

	
	/*
	 * Rotinas para inclusão, alteração e exclusão 
	 * */
	public void alterarClient() {
		
		clienteService = getClienteService();
		cliente = getCliente();
		
		cliente.setId(idCliente);
		setClienteFromView();		
		
		clienteService.alterarCliente(cliente);
		limpa();
	}
	
	public void excluirClient() {
		
		clienteService = getClienteService();
		
		clienteService.excluirCliente(idCliente);
		
		limpa();
	}
	
	public void consultaClient() {
		
		clienteService = getClienteService();
		cliente = getCliente();
		
		Long id = 2L;
		cliente = clienteService.consultaClienteId(id);
		
		idCliente = cliente.getId();
		txtNome.setText(cliente.getName());
		txtEndereco.setText(cliente.getAddress());
		txtBairro.setText(cliente.getDistrict());
		txtCEP.setText(cliente.getCep());
		txtEmail.setText(cliente.getEmail());
		txtTelefone.setText(cliente.getTelefone());
		txtIdade.setText(String.valueOf(cliente.getIdade()));
		
		//System.out.println(cliente.toString());
	}
	
	public void listarClient() {
		
		cliente = getCliente();
				
		List<Client> clientes = new ArrayList<>();
		clientes = clienteService.listaCliente();
		
		for(Client cliente: clientes) {
			System.out.println(cliente.toString());
		}
	}
	
	private void limpa() {
		idCliente = 0l;
		txtNome.setText("");
		txtEndereco.setText("");
		txtBairro.setText("");
		txtCEP.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtIdade.setText("");
	}
	private void setClienteFromView() {
		cliente.setId(idCliente);
		cliente.setName(txtNome.getText());
		cliente.setAddress(txtEndereco.getText());
		cliente.setDistrict(txtBairro.getText());
		cliente.setIdade(Integer.parseInt(txtIdade.getText()));
		cliente.setEmail(txtEmail.getText());
		cliente.setCep(txtCEP.getText());
		cliente.setTelefone(txtTelefone.getText());
	}

	public Client getCliente() {
		return new Client();
	}
	
	public ClientService getClienteService() {
		return new ClientService();
	}
	
	
	
	
	private void initComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 10, 800, 428);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(0, 442, 786, 100);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		btnSalvar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		btnSalvar.setBounds(62, 26, 136, 31);
		panel_1.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		btnCancelar.setBounds(226, 26, 136, 31);
		panel_1.add(btnCancelar);
		//salvarClient();
		//alterarClient();
		//excluirClient():
		//consultaClient();
		//listarClient();
	}
	
	
}
