package com.appvenda.view.table;

import java.util.ArrayList;
import java.util.List;

import com.appvenda.models.Client;

public class TabelaClienteModel extends JTableModel<Client>{

	private static final long serialVersionUID = -5288345439338876506L;

	private final String coluna[] = {"Id","Nome","Endereco","Bairro","Cep","Email","Telefone","Idade"};
	
	private final Integer tamanhoCampo[] = {};
	
	private List<Client> tabela;
	
	public TabelaClienteModel() {
		tabela= new ArrayList<Client>();
		setColuna(coluna);
	}
	
	public TabelaClienteModel(List<Client> tabela) {
		super(tabela);
		this.tabela = tabela;
		setColuna(coluna);
	}
	
	@Override
	public Object getValueAt(int linha, int coluna) {
		
		Client cliente = tabela.get(linha);
		
		switch (coluna) {
		case 0: 
			return cliente.getId();
		case 1:
			return cliente.getName();
		case 2:
			return cliente.getAddress();
		case 3:
			return cliente.getDistrict();
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
		// TODO Auto-generated method stub
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
	
	public Client getCliente (int index) {
		return getTabela().get(index);
	}
	
	public void salvarCliente(Client cliente) {
		getTabela().add(cliente);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
	}
	
	public void alterarCliente(Client cliente, int index) {
		getTabela().set(index, cliente);
		fireTableRowsUpdated(index, index);
	}
	
	public void excluirCliente(int index) {
		getTabela().remove(index);
		fireTableRowsDeleted(index, index);
	}

	public void excluirTudo() {
		getTabela().clear();
		fireTableDataChanged();
	}	
	
	
	public List<Client> getTabela() {
		return tabela;
	}

	public void setTabela(List<Client> tabela) {
		this.tabela = tabela;
	}

	public String[] getColuna() {
		return coluna;
	}

	public Integer[] getTamanhoCampo() {
		return tamanhoCampo;
	}
	
	
}
