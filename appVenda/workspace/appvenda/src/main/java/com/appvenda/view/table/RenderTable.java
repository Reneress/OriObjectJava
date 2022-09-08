package com.appvenda.view.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTable extends DefaultTableCellRenderer {

	private static final long serialVersionUID = -629112532114525794L;

	private DecimalFormat numberFormat = new DecimalFormat("###.##");
	
	private Component JavaComponent;
	
	public RenderTable() {}
	
	
	 @Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
		// TODO Auto-generated method stub
		JavaComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		setHorizontalAlignment(0);
		setBorder(null);
		setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(58,159,161)));
		setFont(new Font("Verdana",Font.ITALIC,20));
		
		if(isSelected) {
			JavaComponent.setForeground(table.getSelectionForeground());
			JavaComponent.setForeground(table.getSelectionBackground());
		}else {
			JavaComponent.setForeground(table.getSelectionForeground());
			JavaComponent.setForeground(row % 2 == 0 ? new Color(240,240,255): table.getBackground());
		}
		
		if(value instanceof Number) {
			Number numero = (Number) value;
			String texto = numberFormat.format(numberFormat);
			setText(texto);
			setForeground(numero.doubleValue()<0?Color.red:Color.black);
			setHorizontalAlignment(RIGHT);
		}
		
		if(value instanceof Integer) {
			setHorizontalAlignment(CENTER);
		}
		
		if(value != null && value instanceof Date) {
			Date data = (Date) value;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String textoData = sdf.format(data);
			setText(textoData);
			setHorizontalAlignment(CENTER);
		}
		
		return JavaComponent;
	}
	
	
}
