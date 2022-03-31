package br.com.proBank.banco.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public enum StatusConta {

	T, F
	
}
