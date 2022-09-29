package com.appvenda.view.cliente;

import java.awt.Color;
//import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import com.appvenda.config.Constantes;
import com.appvenda.config.Page;
import com.appvenda.models.Client;
import com.appvenda.services.ClientService;
import com.appvenda.view.table.RenderHeaderTable;
import com.appvenda.view.table.RenderTable;
import com.appvenda.view.table.TabelaClienteModel;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class TabelaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1110447724870705226L;
	private JPanel contentPane;
	private JTextField textNomePesquisa;
	private JTable tabelaCliente;
	JButton btnPesquisa = new JButton("Pesquisar");
	JButton btnIncluir = new JButton("Incluir");
	JButton btnConsultar = new JButton("Consultar");
	JButton btnAlterar = new JButton("Alterar");
	JButton btnExcluir = new JButton("Excluir");
	JButton btnPrimeiro = new JButton("Primeiro");
	JButton btnAnterior = new JButton("Anterior");
	JButton btnProximo = new JButton("Próximo");
	JButton btnUltimo = new JButton("Ultimo");
	
	private TabelaClienteModel model;
	private Page <Client> page;
	private ClientService clienteService;
	private Client cliente;
	
	private int linha = 0;
	private int coluna = 0;
	private int tamanhoPagina =15;
	private int paginaAtual =0;
	//private JtextFiled nomePesquisa;
	
	
	private static TabelaCliente TABELA_CLIENTE;
	/*
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
	private TabelaCliente() {
		iniComponents();
		eventHandler();
		iniciarTabela();
	}
	
	public static TabelaCliente getInstancia() {
			if(Objects.isNull(TABELA_CLIENTE)) {
				TABELA_CLIENTE = new TabelaCliente(); 
			}
			return TABELA_CLIENTE;
	}
	
	private void eventHandler() {
		
		btnPrimeiro.setBackground(new Color(46, 155, 30));
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual = 1;
				iniciarTabela();
			}
		});
		btnAnterior.setBackground(new Color(46, 155, 30));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (paginaAtual > 1) {
					paginaAtual --;
					iniciarTabela();
				}
			}
		});
		btnProximo.setBackground(new Color(46, 155, 30));
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(paginaAtual< page.getTotalPage()) {
					paginaAtual++;
					iniciarTabela();
				}
			}
		});
		btnUltimo.setBackground(new Color(46, 155, 30));
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual = page.getTotalPage();
				iniciarTabela();
			}
		});
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showClienteFrame(Constantes.Incluir);
				iniciarTabela();
			}

		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getLinhaTabela();
				showClienteFrame(Constantes.Alterar);
				iniciarTabela();
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getLinhaTabela();
				showClienteFrame(Constantes.Excluir);
				iniciarTabela();
			}
		});
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getLinhaTabela();
				showClienteFrame(Constantes.Consultar);
				iniciarTabela();
			}
		});
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	public void iniciarTabela() {
		listarCliente();
		
		//System.out.println(page.getContent().size());
		
		model = new TabelaClienteModel(page.getContent());
		
		
		model.fireTableDataChanged();
		
		tabelaCliente.setModel(model);
		
		RenderHeaderTable renderHeader = new RenderHeaderTable();
		
		tabelaCliente.getTableHeader().setDefaultRenderer(renderHeader);
		
		RenderTable render = new RenderTable();
		
		for(int coluna =0;coluna < model.getColumnCount();coluna ++) {
			tabelaCliente.setDefaultRenderer(model.getColumnClass(coluna), render);
		}
		
		for(int col = 0;col < model.getColumnCount();col++) {
			TableColumn coluna = tabelaCliente.getColumnModel().getColumn(col);
			coluna.setMinWidth(100);
			coluna.setMaxWidth(100);
			coluna.setPreferredWidth(100);
		}
	}	
	
	private void getLinhaTabela() {
		
		cliente = getCliente();
		
		if(tabelaCliente.getSelectedRow() != -1) {
			linha = tabelaCliente.getSelectedRow();
			coluna = tabelaCliente.getSelectedColumn();
			cliente = model.getCliente(linha);
			
		}else {
			JOptionPane.showMessageDialog(null, "Selecione uma Linha na tabela","[ERRO]",JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
	
	private void listarCliente() {
		clienteService = new ClientService();
		page = clienteService.listaPaginada(paginaAtual, tamanhoPagina);
		
		if(paginaAtual == 1) {
			btnPrimeiro.setEnabled(false);
			btnAnterior.setEnabled(false);
		}
		else {
			btnPrimeiro.setEnabled(true);
			btnAnterior.setEnabled(true);
		}
		if(paginaAtual== page.getTotalPage()) {
			btnProximo.setEnabled(false);
			btnUltimo.setEnabled(false);
		}
		else {
			btnProximo.setEnabled(true);
			btnUltimo.setEnabled(true);
		}
		
		if(paginaAtual > page.getTotalPage()) {
			paginaAtual = page.getTotalPage();
		}
		
		paginaAtual = page.getPage();
		tamanhoPagina = page.getPageSize();
	}
	
	private void showClienteFrame(Integer opcaoCadastro) {
		ClientesView view = new ClientesView(cliente,opcaoCadastro);
		view.setLocationRelativeTo(null);
		view.setVisible(true);
	}
	
	private void iniComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 181, 66));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTabela = new JPanel();
		panelTabela.setBounds(10, 144, 843, 295);
		panelTabela.setBackground(new Color(0, 128, 0));
		contentPane.add(panelTabela);
		panelTabela.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 823, 275);
		panelTabela.add(scrollPane);
		
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(scrollPaneCliente);
		
		tabelaCliente = new JTable();
		scrollPaneCliente.setViewportView(tabelaCliente);
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBounds(10, 10, 843, 128);
		panelPesquisa.setBackground(new Color(0, 128, 0));
		contentPane.add(panelPesquisa);
		panelPesquisa.setLayout(null);
		
		JLabel labelPesquisa = new JLabel("Nome:");
		labelPesquisa.setFont(new Font("Verdana", Font.ITALIC, 20));
		labelPesquisa.setBounds(10, 37, 73, 26);
		panelPesquisa.add(labelPesquisa);
		
		textNomePesquisa = new JTextField();
		textNomePesquisa.setFont(new Font("Verdana", Font.ITALIC, 20));
		textNomePesquisa.setBounds(93, 33, 574, 34);
		panelPesquisa.add(textNomePesquisa);
		textNomePesquisa.setColumns(10);
		
		
		
		btnPesquisa.setBackground(Color.WHITE);
		btnPesquisa.setFont(new Font("Verdana", Font.ITALIC, 20));
		btnPesquisa.setBounds(677, 32, 156, 35);
		panelPesquisa.add(btnPesquisa);
		
		
		
		btnIncluir.setBounds(10, 521, 115, 35);
		btnIncluir.setBackground(new Color(240, 240, 240));
		btnIncluir.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnIncluir);
		
		
		
		btnAlterar.setBounds(231, 521, 115, 35);
		btnAlterar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnAlterar);
		
		
		
		btnExcluir.setBounds(463, 521, 115, 35);
		btnExcluir.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnExcluir);
		
		
		
		btnConsultar.setBounds(696, 521, 157, 35);
		btnConsultar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnConsultar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 449, 843, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
	
		btnPrimeiro.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		btnPrimeiro.setBounds(10, 19, 113, 21);
		panel.add(btnPrimeiro);
		
		
		
		btnAnterior.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		btnAnterior.setBounds(221, 19, 105, 21);
		panel.add(btnAnterior);
		
		
		
		btnProximo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		btnProximo.setBounds(462, 19, 105, 21);
		panel.add(btnProximo);
		
		
		
		btnUltimo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		btnUltimo.setBounds(728, 19, 105, 21);
		panel.add(btnUltimo);
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

	public Client getCliente() {
		return new Client();
	}

	
	
}
