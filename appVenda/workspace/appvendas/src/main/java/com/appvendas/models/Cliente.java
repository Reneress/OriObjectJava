package com.appvendas.models;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.appvendas.services.errors.CampoRequerido;

@Entity
@Table(name="TAB_CLIENTE")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 6478139992497527956L;

	private Long id;
	
	@CampoRequerido(valor=1, mensagem = "O nome deve ser informado")
	private String nome;

	@CampoRequerido(valor=2, mensagem = "O endereço deve ser informado")
	private String endereco;
	
	@CampoRequerido(valor=3, mensagem = "O bairro deve ser informado")
	private String bairro;

	@CampoRequerido(valor=4)
	private String cep;
	
	@CampoRequerido(valor=5, mensagem = "O email deve ser informado")
	private String email;
	
	@CampoRequerido(valor=6, mensagem = "O telefone deve ser informado")
	private String telefone;

	@CampoRequerido(valor=7, mensagem = "A idade deve ser informado")
	private Integer idade;
	
    
	
	public Cliente() {
		
	}


	public Cliente(Long id, String nome, String endereco, String bairro, String cep, String email, String telefone,
			Integer idade) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.email = email;
		this.telefone = telefone;
		this.idade = idade;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENTE_ID")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "CLIENTE_NOME", length = 100, nullable = false)
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "CLIENTE_ENDERECO", length = 100, nullable = false)
	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "CLIENTE_BAIRRO", length = 50, nullable = false)
	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "CLIENTE_CEP", length = 10, nullable = false)
	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "CLIENTE_EMAIL", length = 100, nullable = false)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "CLIENTE_TELEFONE", length = 15, nullable = false)
	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "CLIENTE_IDADE",  nullable = false)
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", cep=" + cep
				+ ", email=" + email + ", telefone=" + telefone + ", idade=" + idade + "]";
	}

     
		

}
