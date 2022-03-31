package br.com.proBank.banco.dto;

import java.math.BigDecimal;

public class TransferenciaDTO {
	
	private Long idAgenciaOrigem;
	private Long idContaOrigem; 
	
	private Long idAgenciaDestino;
	private Long idContaDestino;
	
	private BigDecimal valor;

	public Long getIdAgenciaOrigem() {
		return idAgenciaOrigem;
	}

	public void setIdAgenciaOrigem(Long idAgenciaOrigem) {
		this.idAgenciaOrigem = idAgenciaOrigem;
	}

	public Long getIdContaOrigem() {
		return idContaOrigem;
	}

	public void setIdContaOrigem(Long idContaOrigem) {
		this.idContaOrigem = idContaOrigem;
	}

	public Long getIdAgenciaDestino() {
		return idAgenciaDestino;
	}

	public void setIdAgenciaDestino(Long idAgenciaDestino) {
		this.idAgenciaDestino = idAgenciaDestino;
	}

	public Long getIdContaDestino() {
		return idContaDestino;
	}

	public void setIdContaDestino(Long idContaDestino) {
		this.idContaDestino = idContaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
