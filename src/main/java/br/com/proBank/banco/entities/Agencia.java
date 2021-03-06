package br.com.proBank.banco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="agencia")
public class Agencia {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@Column(length = 200) 
	@NotNull
	private String nome;
	 
	@Column(length = 500)
	@NotNull
	private String endereco;  
	
	public Agencia() { 
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	} 
	

}
