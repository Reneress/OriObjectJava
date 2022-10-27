package com.appvendas.main;

import com.appvendas.view.cliente.TabelaClienteView;

public class Menu {

	public static void main(String[] args) {
		
		TabelaClienteView tabelaClienteView = TabelaClienteView.getInstancia();
        tabelaClienteView.setVisible(true);		

	}

}
