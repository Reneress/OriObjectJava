package com.appvendas.models;

import java.util.Date;


//@Entity
//@Table(name="TAB_PEDIDO")
public class Pedido {
	
	
	private Long idPedido;
	private Date dataPedido;
	private Double valorPedido;
	
	private Cliente cliente;
	
	
	public Pedido() {
		super();
	}

	public Pedido(Long idPedido, Date dataPedido, Double valorPedido, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.valorPedido = valorPedido;
		this.cliente = cliente;
	}

	
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "CLIENTE_ID")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}
