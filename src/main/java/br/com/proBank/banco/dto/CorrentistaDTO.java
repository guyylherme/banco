package br.com.proBank.banco.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.proBank.banco.entities.Correntista;

public class CorrentistaDTO {
		
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String cpf;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate nascimento; 
	 
	 
	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
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

	public Correntista toCorrentista() {

		Correntista correntista = new Correntista(); 
		correntista.setNome(this.nome);
		correntista.setCpf(this.cpf);
		correntista.setNascimento(this.nascimento);  
		
		return correntista;
	}
	

}
