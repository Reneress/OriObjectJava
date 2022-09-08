package com.appvenda.view.cliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.appvenda.config.Page;
import com.appvenda.models.Client;
import com.appvenda.services.ClientService;
import com.appvenda.view.table.RenderTable;
import com.appvenda.view.table.TabelaClienteModel;

public class TabelaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1110447724870705226L;
	private JPanel contentPane;
	private JTextField textNomePesquisa;
	private JTable tabelaCliente;

	
	private TabelaClienteModel model;
	private Page <Client> page;
	private ClientService clienteService;
	
	private int linha = 0;
	private int coluna =0;
	private int tamanhoPagina =10;
	private int paginaAtual =0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaCliente frame = new TabelaCliente();
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
	public TabelaCliente() {
		iniComponents();
		eventHandler();
		iniciarTabela();
	}
	
	private void eventHandler() {
		
	}
	
	public void iniciarTabela() {
		listarCliente();
		
		System.out.println(page.getContent().size());
		
		model = new TabelaClienteModel(page.getContent());
		
		tabelaCliente.setModel(model);
		
		model.fireTableDataChanged();
		
		RenderTable render = new RenderTable();
		for(int coluna =0;coluna < model.getColumnCount();coluna ++) {
			tabelaCliente.setDefaultRenderer(model.getColumnClass(coluna), render);
		}
		
	}	
	
	private void listarCliente() {
		clienteService = getClienteService();
		page = clienteService.listaPaginada(paginaAtual, tamanhoPagina);
	}
	
	
	private void iniComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 181, 66));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTabela = new JPanel();
		panelTabela.setBounds(10, 144, 767, 295);
		panelTabela.setBackground(new Color(81, 184, 31));
		contentPane.add(panelTabela);
		panelTabela.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 747, 275);
		panelTabela.add(scrollPane);
		
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPane.setViewportView(scrollPaneCliente);
		
		tabelaCliente = new JTable();
		scrollPaneCliente.setViewportView(tabelaCliente);
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBounds(10, 10, 767, 128);
		panelPesquisa.setBackground(new Color(46, 155, 30));
		contentPane.add(panelPesquisa);
		panelPesquisa.setLayout(null);
		
		JLabel labelPesquisa = new JLabel("Nome:");
		labelPesquisa.setFont(new Font("Verdana", Font.ITALIC, 20));
		labelPesquisa.setBounds(10, 32, 73, 26);
		panelPesquisa.add(labelPesquisa);
		
		textNomePesquisa = new JTextField();
		textNomePesquisa.setFont(new Font("Verdana", Font.ITALIC, 20));
		textNomePesquisa.setBounds(93, 33, 498, 26);
		panelPesquisa.add(textNomePesquisa);
		textNomePesquisa.setColumns(10);
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.setBackground(new Color(81, 184, 31));
		btnPesquisa.setFont(new Font("Verdana", Font.ITALIC, 20));
		btnPesquisa.setBounds(601, 32, 156, 26);
		panelPesquisa.add(btnPesquisa);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(32, 487, 115, 35);
		btnIncluir.setBackground(new Color(240, 240, 240));
		btnIncluir.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnIncluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(179, 487, 115, 35);
		btnAlterar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(319, 487, 115, 35);
		btnExcluir.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(466, 487, 157, 35);
		btnConsultar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnConsultar);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTextNomePesquisa() {
		return textNomePesquisa;
	}

	public void setTextNomePesquisa(JTextField textNomePesquisa) {
		this.textNomePesquisa = textNomePesquisa;
	}

	public JTable getTable() {
		return tabelaCliente;
	}

	public void setTable(JTable table) {
		tabelaCliente = table;
	}

	public TabelaClienteModel getModel() {
		return model;
	}

	public void setModel(TabelaClienteModel model) {
		this.model = model;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int getTamanhoPagina() {
		return tamanhoPagina;
	}

	public void setTamanhoPagina(int tamanhoPagina) {
		this.tamanhoPagina = tamanhoPagina;
	}

	public int getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public JTable getTabelaCliente() {
		return tabelaCliente;
	}

	public void setTabelaCliente(JTable tabelaCliente) {
		this.tabelaCliente = tabelaCliente;
	}

	public Page<Client> getPage() {
		return page;
	}

	public void setPage(Page<Client> page) {
		this.page = page;
	}

	public ClientService getClienteService() {
		return new ClientService();
	}

	public void setClienteService(ClientService clienteService) {
		this.clienteService = clienteService;
	}
	
	
	
}
