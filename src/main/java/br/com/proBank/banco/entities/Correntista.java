package br.com.proBank.banco.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="correntista")
public class Correntista {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@Column(length = 200) 
	@NotNull
	private String nome;
	
	@Column(length = 11) 
	private String cpf; 
	
	@NotNull
	private LocalDate nascimento;
	 
	@OneToOne(mappedBy = "correntista") 
	private ContaCorrente contaCorrente;
	
	public Correntista() { 
	}
	
	public String getNome() {
		return nome;
	}
	 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	 
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	

}
