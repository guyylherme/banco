package br.com.proBank.banco.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SaqueDTO {

	@NotNull
	@Min(value = 0)
	private BigDecimal valor;
	
	@NotNull
	private Long idAgencia;
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Long getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}  
	
}
