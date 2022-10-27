package com.appvendas.models;

public class Produto {
	
	private Long idProduto;
	private String nomeProduto;
	private Integer quantidade;
	private Double valorProduto;
	
	
	public Produto() {
		super();
	}
	
	
	public Produto(Long idProduto, String nomeProduto, Integer quantidade, Double valorProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.valorProduto = valorProduto;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}
	

	
	
}
