package com.appvenda.models;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Pedidos {
	private Long idPedido;
	private Date dataPedido;
	private  Double valorPedido;
	
	private Client cliente;
	
	
	
	
	
	
	

	public Pedidos() {
		super();
	}

	public Pedidos(Long idPedido, Date dataPedido, Double valorPedido, Client cliente) {
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

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", referencedColumnName = "id")
	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	
	
	
}
