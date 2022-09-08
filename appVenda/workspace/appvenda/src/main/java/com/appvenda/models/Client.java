package com.appvenda.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CLIENT")
public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3827476455444192318L;
	
	private long id;
	private String name;
	private String Address;
	private String district;
	private String cep;
	private String email;
	private String telefone;
	private Integer idade;
	
	public Client() {
		super();
	}
	
	public Client(long id, String name, String address, String district, String cep, String email, String telefone,
			Integer idade) {
		super();
		this.id = id;
		this.name = name;
		this.Address = address;
		this.district = district;
		this.cep = cep;
		this.email = email;
		this.telefone = telefone;
		this.idade = idade;
	}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
@Column(name = "nome", length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
@Column(name = "endereco",length = 50)
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
@Column(name = "bairro", length = 50)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
@Column(name = "cep", length = 11)
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
@Column(name = "email", length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
@Column(name = "telefone", length = 15)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
@Column(name = "idade",  length = 3)
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

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
		Client other = (Client) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", Address=" + Address + ", district=" + district + ", cep="
				+ cep + ", email=" + email + ", telefone=" + telefone + ", idade=" + idade + "]";
	}
	
	
	
	

}
