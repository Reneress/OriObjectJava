package com.appvenda.models;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

public class Perfil {
	private Long idPerfil;
	private String nomePerfil;
	
	
	private List<User> listaUsuarios;
	
	
	
	
	
	public Perfil() {
		super();
	}
	public Perfil(Long idPerfil, String nomePerfil) {
		super();
		this.idPerfil = idPerfil;
		this.nomePerfil = nomePerfil;
	}
	public Long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	
	@ManyToMany(mappedBy = "listaPerfis", fetch = FetchType.LAZY)
	public List<User> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<User> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	
	
}
