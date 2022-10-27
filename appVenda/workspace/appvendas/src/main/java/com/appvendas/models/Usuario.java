package com.appvendas.models;

import java.beans.Transient;
import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "TAB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -1792616006672321539L;

	private Integer id;
	private String  username;
	private String  email;
	private String  senha;
	private String  confirme;
	private boolean ativo = Boolean.FALSE;
	
	

	public Usuario() {
	}

	public Usuario(Integer id, String username, String email, String senha, String confirme, boolean ativo) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.senha = senha;
		this.confirme = confirme;
		this.ativo = ativo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NOME", length = 100, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "EMAIL", length = 100, nullable = false, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "SENHA", length = 100, nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Transient
	public String getConfirme() {
		return confirme;
	}

	public void setConfirme(String confirme) {
		this.confirme = confirme;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
    //@ManyToMany(fetch = FetchType.LAZY) 
   // @JoinTable(name = "TAB_USUARIO_PERFIL",
    //			joinColumns = @JoinColumn(name="USUARIO_ID"),
    //			inverseJoinColumns = @JoinColumn(name="PERFIL_ID"))
	//public List<Perfil> getListaPerfis() {
	//	return listaPerfis;
	//}

	//public void setListaPerfis(List<Perfil> listaPerfis) {
	//	this.listaPerfis = listaPerfis;
	//}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email=" + email + ", senha=" + senha + ", confirme="
				+ confirme + ", ativo=" + ativo + "]";
	}

}
