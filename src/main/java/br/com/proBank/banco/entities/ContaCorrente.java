package br.com.proBank.banco.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="conta_corrente")
public class ContaCorrente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  
	private BigDecimal limite; 
	private BigDecimal saldo;
	
	@Enumerated(EnumType.STRING)
	private StatusConta ativa;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_correntista", referencedColumnName = "id")
	private Correntista correntista;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_agencia")
	private Agencia agencia;
	
	
	public ContaCorrente() { 
	}
  
	public Long getId() {
		return id;
	} 

	public void setId(Long id) {
		this.id = id;
	}


	public BigDecimal getLimite() {
		return limite;
	}


	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}


	public BigDecimal getSaldo() {
		return saldo;
	}


	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}


	public Correntista getCorrentista() {
		return correntista;
	}


	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}


	public Agencia getAgencia() {
		return agencia;
	}


	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public StatusConta getAtiva() {
		return ativa;
	}

	public void setAtiva(StatusConta ativa) {
		this.ativa = ativa;
	}
	 
	

}
