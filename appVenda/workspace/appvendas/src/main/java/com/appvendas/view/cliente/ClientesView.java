package com.appvendas.view.cliente;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.appvendas.config.Constantes;
import com.appvendas.message.ModelResponse;
import com.appvendas.models.Cliente;
import com.appvendas.services.ClienteService;
import com.appvendas.services.errors.ErrosData;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ClientesView extends JFrame {


	private static final long serialVersionUID = 6944798959841337479L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField endereco;
	private JTextField bairro;
	private JTextField cep;
	private JTextField email;
	private JTextField telefone;
	private JTextField idade;
	
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	
	private JLabel MensagemNome;
	private JLabel MessageEndereco;
	private JLabel MessageBairro;
	private JLabel MessageCep;
	private JLabel MessageEmail;
	private JLabel MessageTelefone;
	private JLabel MessageIdade;
	
	
	private Long idCliente = 0L;
	private ClienteService clienteService;
    private Cliente cliente; 	
    
    private ModelResponse<Cliente> modelResponse;
    private ModelResponse<ErrosData> errors;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientesView frame = new ClientesView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ClientesView(Cliente cliente, Integer opcaoCadastro) {
		
		initComponents();
		
		eventHandler();
		
		btnSalvar.setText("Salvar"); 
		btnCancelar.setText("Cancelar");
		
		if (opcaoCadastro == Constantes.INCLUIR) {
			btnSalvar.setFont(new Font("Verdana", Font.BOLD, 20));
			btnSalvar.setBounds(178, 24, 149, 52);
			btnCancelar.setFont(new Font("Verdana", Font.BOLD, 20));
			btnCancelar.setBounds(347, 24, 149, 52);
		    btnCancelar = new JButton("Cancelar");
		} else if (opcaoCadastro == Constantes.ALTERAR) {
			consultarCliente(cliente.getId());
			btnSalvar.setFont(new Font("Verdana", Font.BOLD, 20));
			btnSalvar.setBounds(178, 24, 149, 52);
			btnCancelar.setFont(new Font("Verdana", Font.BOLD, 20));
			btnCancelar.setBounds(347, 24, 149, 52);
		} else if (opcaoCadastro == Constantes.EXCLUIR) {
			consultarCliente(cliente.getId());
			btnSalvar.setText("Excluir"); 
			btnSalvar.setFont(new Font("Verdana", Font.BOLD, 20));
			btnSalvar.setBounds(178, 24, 149, 52);
			btnCancelar.setFont(new Font("Verdana", Font.BOLD, 20));
		 	btnCancelar.setBounds(347, 24, 149, 52);
		} else if (opcaoCadastro == Constantes.CONSULTAR) {
			consultarCliente(cliente.getId());
			btnCancelar.setFont(new Font("Verdana", Font.BOLD, 20));
			btnCancelar.setBounds(178, 24, 149, 52);
		}
	}
	


	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 704, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 696, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(60, 71, 109, 36);
		panel.add(lblNome);
		
		nome = new JTextField();
		nome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				nome.setBorder(null);
				MensagemNome.setVisible(false);
			}
		});
		nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
					endereco.requestFocus();
				}
				
			}
		});
		nome.setBorder(null);
		nome.setFont(new Font("Verdana", Font.PLAIN, 20));
		nome.setBounds(179, 71, 403, 36);
		panel.add(nome);
		nome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setFont(new Font("Verdana", Font.BOLD, 20));
		lblEndereco.setBounds(24, 126, 145, 36);
		panel.add(lblEndereco);
		
		endereco = new JTextField();
		endereco.setFont(new Font("Verdana", Font.PLAIN, 20));
		endereco.setColumns(10);
		endereco.setBorder(null);
		endereco.setBounds(179, 126, 403, 36);
		panel.add(endereco);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 20));
		lblBairro.setBounds(24, 184, 145, 36);
		panel.add(lblBairro);
		
		bairro = new JTextField();
		bairro.setFont(new Font("Verdana", Font.PLAIN, 20));
		bairro.setColumns(10);
		bairro.setBorder(null);
		bairro.setBounds(179, 184, 403, 36);
		panel.add(bairro);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Verdana", Font.BOLD, 20));
		lblCep.setBounds(24, 244, 145, 36);
		panel.add(lblCep);
		
		cep = new JTextField();
		cep.setFont(new Font("Verdana", Font.PLAIN, 20));
		cep.setColumns(10);
		cep.setBorder(null);
		cep.setBounds(179, 244, 403, 36);
		panel.add(cep);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 20));
		lblEmail.setBounds(24, 304, 145, 36);
		panel.add(lblEmail);
		
		email = new JTextField();
		email.setFont(new Font("Verdana", Font.PLAIN, 20));
		email.setColumns(10);
		email.setBorder(null);
		email.setBounds(179, 304, 403, 36);
		panel.add(email);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTelefone.setBounds(24, 365, 145, 36);
		panel.add(lblTelefone);
		
		telefone = new JTextField();
		telefone.setFont(new Font("Verdana", Font.PLAIN, 20));
		telefone.setColumns(10);
		telefone.setBorder(null);
		telefone.setBounds(179, 365, 403, 36);
		panel.add(telefone);
		
		idade = new JTextField();
		idade.setFont(new Font("Verdana", Font.PLAIN, 20));
		idade.setColumns(10);
		idade.setBorder(null);
		idade.setBounds(179, 423, 403, 36);
		panel.add(idade);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdade.setFont(new Font("Verdana", Font.BOLD, 20));
		lblIdade.setBounds(24, 423, 145, 36);
		panel.add(lblIdade);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 23, 2, 2);
		panel.add(scrollPane);
		
		MensagemNome = new JLabel("");
		MensagemNome.setBounds(179, 105, 403, 13);
		panel.add(MensagemNome);
		
		MessageEndereco = new JLabel("");
		MessageEndereco.setBounds(179, 161, 403, 13);
		panel.add(MessageEndereco);
		
		MessageBairro = new JLabel("");
		MessageBairro.setBounds(179, 221, 403, 13);
		panel.add(MessageBairro);
		
		MessageCep = new JLabel("");
		MessageCep.setBounds(179, 281, 403, 13);
		panel.add(MessageCep);
		
		MessageEmail = new JLabel("");
		MessageEmail.setBounds(179, 342, 403, 13);
		panel.add(MessageEmail);
		
		MessageTelefone = new JLabel("");
		MessageTelefone.setBounds(179, 400, 403, 13);
		panel.add(MessageTelefone);
		
		MessageIdade = new JLabel("");
		MessageIdade.setBounds(179, 457, 403, 13);
		panel.add(MessageIdade);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(new Color(0, 128, 0));
		panelBotoes.setBounds(0, 521, 696, 99);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		btnSalvar = new JButton();
		panelBotoes.add(btnSalvar);
		
		btnCancelar = new JButton();
		panelBotoes.add(btnCancelar);
		
		//btnSalvar.setFont(new Font("Verdana", Font.BOLD, 20));
		//btnSalvar.setBounds(178, 24, 149, 52);
	
		//btnCancelar = new JButton("Cancelar");
		//btnCancelar.setFont(new Font("Verdana", Font.BOLD, 20));
		//btnCancelar.setBounds(347, 24, 149, 52);
		//panelBotoes.add(btnCancelar);
		//salvarCliente();
		//alterarCliente();
		//excluirCliente();
		//consultarCliente();
		//listarClientes();
		
		
	
		MensagemNome.setVisible(false);
		MessageEndereco.setVisible(false);
		MessageBairro.setVisible(false);
		MessageCep.setVisible(false);
		MessageEmail.setVisible(false);
		MessageTelefone.setVisible(false);
		MessageIdade.setVisible(false);
	}
	

	private void eventHandler() {
	
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( idCliente == 0L ) {
					salvarCliente();
				} else {
					alterarCliente();
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	
	}

	/*
	 * rotinas para Inclusão, Alteração e Exclusão de um 
	 * registro
	 * 
	 * Manutenção de cadastro
	 * 
	*/


	@SuppressWarnings("unchecked")
	public void salvarCliente() {
		
		clienteService = getClienteService();
		cliente = getCliente();
		setClienteFromView();
		
		errors = (ModelResponse<ErrosData>) clienteService.validarDadosFromView(cliente);
		
		
		if (errors.isError()) {
			showErrorClienteFromServidor();
            JOptionPane.showMessageDialog(null, modelResponse.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE );			
		} else {
			modelResponse = (ModelResponse<Cliente>) clienteService.incluir(cliente);
			cliente = modelResponse.getObject();
            JOptionPane.showMessageDialog(null, modelResponse.getMessage(), "Inclusão", JOptionPane.INFORMATION_MESSAGE );			
		}
	    limparClienteView();
	}

	
	
	
	private void showErrorClienteFromServidor() {
		
		for (ErrosData erro: errors.getListObject()) {
			if (erro.getNumeroCampo() == 1) {
				MensagemNome.setVisible(true);
				MensagemNome.setText(erro.getShowMensagemErro());
				MensagemNome.setForeground(Color.red);
				nome.setBorder(BorderFactory.createLineBorder(Color.red,2));
			}
			if (erro.getNumeroCampo() == 2) {
				MessageEndereco.setVisible(true);
				MessageEndereco.setText(erro.getShowMensagemErro());
				MessageEndereco.setForeground(Color.red);
				endereco.setBorder(BorderFactory.createLineBorder(Color.red,2));
			}
			if (erro.getNumeroCampo() == 3) {
				MessageBairro.setVisible(true);
				MessageBairro.setText(erro.getShowMensagemErro());
				MessageBairro.setForeground(Color.red);
				bairro.setBorder(BorderFactory.createLineBorder(Color.red,2));
			}
			if (erro.getNumeroCampo() == 4) {
				MessageCep.setVisible(true);
				MessageCep.setText(erro.getShowMensagemErro());
				MessageCep.setForeground(Color.red);
				cep.setBorder(BorderFactory.createLineBorder(Color.red,2));
			}
			if (erro.getNumeroCampo() == 5) {
				MessageEmail.setVisible(true);
				MessageEmail.setText(erro.getShowMensagemErro());
				MessageEmail.setForeground(Color.red);
				email.setBorder(BorderFactory.createLineBorder(Color.red,2));
			}
			if (erro.getNumeroCampo() == 6) {
				MessageTelefone.setVisible(true);
				MessageTelefone.setText(erro.getShowMensagemErro());
				MessageTelefone.setForeground(Color.red);
				telefone.setBorder(BorderFactory.createLineBorder(Color.red,2));
			}
			if (erro.getNumeroCampo() == 7) {
				MessageIdade.setVisible(true);
				MessageIdade.setText(erro.getShowMensagemErro());
				MessageIdade.setForeground(Color.red);
				idade.setBorder(BorderFactory.createLineBorder(Color.red,2));
			}
		}
		
	}



	@SuppressWarnings("unchecked")
	public void alterarCliente() {
		
		clienteService = getClienteService();
		cliente = getCliente();
		cliente.setId(idCliente);
		setClienteFromView();		
		modelResponse = (ModelResponse<Cliente>) clienteService.alterar(cliente);	
		if (modelResponse.isError()) {
            JOptionPane.showMessageDialog(null, modelResponse.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE );			
		} else {
			cliente = modelResponse.getObject();
            JOptionPane.showMessageDialog(null, modelResponse.getMessage(), "Alteração", JOptionPane.INFORMATION_MESSAGE );			
		}
		limparClienteView();
	}
	

	@SuppressWarnings("unchecked")
	public void excluirCliente() {
		clienteService = getClienteService();
		setClienteFromView();
		modelResponse = (ModelResponse<Cliente>) clienteService.excluir(cliente);
		if (modelResponse.isError()) {
            JOptionPane.showMessageDialog(null, modelResponse.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE );			
		} else {
			cliente = modelResponse.getObject();
            JOptionPane.showMessageDialog(null, modelResponse.getMessage(), "Exclusão", JOptionPane.INFORMATION_MESSAGE );			
		}
		limparClienteView();
	}
	
	@SuppressWarnings("unchecked")
	public void consultarCliente(Long id) {
		clienteService = getClienteService();
		cliente = getCliente();
		modelResponse = (ModelResponse<Cliente>) clienteService.consultaPorId(id);
		if (modelResponse.isError()) {
            JOptionPane.showMessageDialog(null, modelResponse.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE );			
		} else {
			cliente = modelResponse.getObject();
			getClienteFromDataBase();
		}
	}
	
	
	private void getClienteFromDataBase() {
		idCliente = cliente.getId();
		nome.setText(cliente.getNome());
		endereco.setText(cliente.getEndereco());
		bairro.setText(cliente.getBairro());
		cep.setText(cliente.getCep());
		email.setText(cliente.getEmail());
		telefone.setText(cliente.getTelefone());
		idade.setText(String.valueOf(cliente.getIdade()));
	}
	
	
//	public void listarClientes() {
//		ClienteService clienteService = new ClienteService();
//
//		List<Cliente> clientes = new ArrayList<>();
//		
//		//clientes = clienteService.listaCliente();
//		
//		for (Cliente cliente :clientes) {
//			System.out.println(cliente.toString());
//		}
//		
//	}
	
	private void limparClienteView() {
		idCliente = 0L;
        nome.setText("");
		endereco.setText("");
		bairro.setText("");
		cep.setText("");
		email.setText("");
		telefone.setText("");
		idade.setText("");
	}
	
	private void setClienteFromView() {
		cliente.setNome(nome.getText());
		cliente.setEndereco(endereco.getText());
		cliente.setBairro(bairro.getText());
		cliente.setIdade(Integer.parseInt(idade.getText()));
		cliente.setEmail(email.getText());
		cliente.setCep(cep.getText());
		cliente.setTelefone(telefone.getText());
	}
	
	
	public Cliente getCliente() {
		return new Cliente();
	}
	
	
	public ClienteService getClienteService() {
		return new ClienteService();
	}



	public ModelResponse<Cliente> getModelResponse() {
		return modelResponse;
	}



	public void setModelResponse(ModelResponse<Cliente> modelResponse) {
		this.modelResponse = modelResponse;
	}
}
