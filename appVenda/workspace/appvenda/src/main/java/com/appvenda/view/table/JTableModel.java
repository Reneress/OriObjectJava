package com.appvenda.view.table;

import javax.swing.table.AbstractTableModel;


import java.util.ArrayList;
import java.util.List;

public abstract class JTableModel<T> extends AbstractTableModel{
	
	private static final long serialVersionUID = 1114546107635782801L;
	
	protected List<T> tabela;
	protected String coluna[];
	
	public JTableModel() {
		tabela = new ArrayList<>();
	}

	
	public JTableModel(List<T> tabela) {
		this.tabela = tabela;
	}

	@Override
	public int getRowCount() {
		
		return tabela.size();
	}

	@Override
	public int getColumnCount() {
		
		return coluna.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return null;
	}
	
	public T getValueAt(int linha) {
		
		return tabela.get(linha);
	}
	
	public T setValueAt(int linha, T objeto) {
		return tabela.set(linha, objeto);
	}


	public List<T> getTabela() {
		return tabela;
	}


	public void setTabela(List<T> tabela) {
		this.tabela = tabela;
	}


	public String[] getColuna() {
		return coluna;
	}


	public void setColuna(String[] coluna) {
		this.coluna = coluna;
	}

	
}
