package br.com.proBank.banco.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonRawValue;

import br.com.proBank.banco.entities.Agencia;
import br.com.proBank.banco.entities.ContaCorrente;
import br.com.proBank.banco.entities.StatusConta;

public class ContaDTO implements Serializable{
	 
	private Long id;
	
	@NotNull 
	private BigDecimal limite;
	
	@NotNull 
	private String saldo;
	
	@NotNull 
	private Long agenciaId;
	
	@NotNull 
	private CorrentistaDTO correntista; 

	
	public CorrentistaDTO getCorrentista() {
		return correntista;
	}

	public void setCorrentista(CorrentistaDTO correntista) {
		this.correntista = correntista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	public Long getAgenciaId() {
		return agenciaId;
	}

	public void setAgenciaId(Long agenciaId) {
		this.agenciaId = agenciaId;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getLimite() {
		return limite;
	}
	
	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}
	
	public String getSaldo() {
		return saldo;
	}

	public void setValor(String saldo) {
		this.saldo = saldo;
	} 
	
	public ContaCorrente toContaCorrente() {  
		ContaCorrente conta = new ContaCorrente();  
		conta.setSaldo(new BigDecimal(this.saldo));
		conta.setAtiva(StatusConta.T); 
		conta.setLimite(this.limite); 
		
		return conta;
	} 
}
