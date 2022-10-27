package com.appvendas.view.cliente;

import java.util.ArrayList;
import java.util.List;

import com.appvendas.models.Cliente;
import com.appvendas.view.table.JTableModel;

public class TabelaClienteModel extends JTableModel<Cliente>{

	private static final long serialVersionUID = -1799110164468447674L;
	
	
	private final String colunaCliente[] = {"Código",
			                         "Nome", 
			                         "Endereco", 
			                         "Bairro", 
			                         "Cep", 
			                         "Email",
			                         "Telefone",
			                         "Idade"};
	
	private final Integer tamanhoCampo[] = {};
	
	
	private List<Cliente> tabela;
	
	
	public TabelaClienteModel() {
		tabela = new ArrayList<Cliente>();
		this.coluna = colunaCliente;
	}
	

	public TabelaClienteModel(List<Cliente> tabela) {
		super(tabela);
		this.tabela = tabela;
		this.coluna = colunaCliente;
		
	}
	
	
	@Override
	public Object getValueAt(int linha, int coluna) {
        Cliente cliente = tabela.get(linha);
		switch(coluna) {
		case 0:
			return cliente.getId();
		case 1: 
			return cliente.getNome();
		case 2: 
			return cliente.getEndereco();
		case 3: 
			return cliente.getBairro();
		case 4: 
			return cliente.getCep();
		case 5: 
			return cliente.getEmail();
		case 6: 
			return cliente.getTelefone();
		case 7: 
			return cliente.getIdade();	
		default:
			return null;
		}
	}
	
	
	@Override
	public Class<?> getColumnClass(int coluna) {

		switch (coluna) {
		case 0:
			return Long.class;
		case 1: 
			return String.class;
		case 2: 
			return String.class;
		case 3: 
			return String.class;
		case 4: 
			return String.class;
		case 5: 
			return String.class;
		case 6: 
			return String.class;
		case 7: 
			return Integer.class;	
		default:
			return null;
		}
		
	}
	
	
	public Cliente getCliente(int index) {
		return getTabela().get(index); 
	}
	
	public void salvarCliente(Cliente cliente) {
		getTabela().add(cliente);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	public void alterarCliente(Cliente cliente, int index) {
		getTabela().set(index, cliente);
		fireTableRowsUpdated(index, index);
	}
	
	
	public void excluirCliente(int index) {
		getTabela().remove(index);
		fireTableRowsDeleted(index, index);
	}
	
	
	
	
	


	public List<Cliente> getTabela() {
		return tabela;
	}


	public void setTabela(List<Cliente> tabela) {
		this.tabela = tabela;
	}


	public String[] getColuna() {
		return coluna;
	}


	public Integer[] getTamanhoCampo() {
		return tamanhoCampo;
	}
	
	
    
	
}
