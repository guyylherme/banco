package br.com.proBank.banco.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proBank.banco.dto.ContaDTO;
import br.com.proBank.banco.dto.DepositoDTO;
import br.com.proBank.banco.dto.SaqueDTO;
import br.com.proBank.banco.dto.TransferenciaDTO;
import br.com.proBank.banco.entities.ContaCorrente;
import br.com.proBank.banco.entities.Correntista;
import br.com.proBank.banco.service.ContaCorrenteService;

@RestController
public class ContaCorrenteRest {
	
	private ContaCorrenteService contaCorrenteService;
	
	public ContaCorrenteRest(ContaCorrenteService contaCorrenteService) {
		this.contaCorrenteService = contaCorrenteService;
	} 

	//Consultar saldo pela agência e número da conta
	@GetMapping("/api/conta/{idConta}/{idAgencia}/saldo")
	public ResponseEntity<BigDecimal> buscarContaCorrente(@PathVariable("idAgencia") Long idAgencia,
		@PathVariable("idConta") Long idConta) {
		 		
		ContaCorrente contaBuscada = contaCorrenteService.findByAgenciaEConta(idConta, idAgencia);  
		return ResponseEntity.status(HttpStatus.OK).body(contaBuscada.getSaldo());
	}
	
	//Consultar saldo pelo CPF
		@GetMapping("/api/correntista/{cpf}")
	public ResponseEntity<Correntista> buscarConta(@PathVariable("cpf") String cpf) {
			 		
			Correntista correntista = contaCorrenteService.findByCpf(cpf);  
			return ResponseEntity.status(HttpStatus.OK).body(correntista);
		}
	 	 
	// Criando conta corrente
	@PostMapping("/api/criar_conta")
	public ResponseEntity<ContaCorrente> criarConta(@Valid @RequestBody ContaDTO contaDTO){  
 
		ContaCorrente novaConta = contaDTO.toContaCorrente(); 
		Correntista novoCorrentista = contaDTO.getCorrentista().toCorrentista(); 
		ContaCorrente conta = contaCorrenteService.salvarContaCorrente(novaConta, novoCorrentista, contaDTO.getAgenciaId());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(conta);
		
	} 
	
	// Deposito conta corrente
	@PostMapping("/api/conta/{idConta}/deposito")
	public ResponseEntity<BigDecimal> deposito(@Valid @RequestBody DepositoDTO depositoDto, @PathVariable("idConta") Long idConta) {
		 
		BigDecimal saldoAtual = contaCorrenteService.deposito(idConta, depositoDto.getIdAgencia(), depositoDto.getValor());
		
		return ResponseEntity.status(HttpStatus.OK).body(saldoAtual);
	}
	
	// Saque conta corrente
	@PostMapping("/api/conta/{idConta}/saque")
	public ResponseEntity<BigDecimal> saque(@Valid @RequestBody SaqueDTO saqueDto, @PathVariable("idConta") Long idConta) {
		 
		BigDecimal saldoAtual = contaCorrenteService.saque(idConta, saqueDto.getIdAgencia(), saqueDto.getValor());
		
		return ResponseEntity.status(HttpStatus.OK).body(saldoAtual);
	}
	
	// Desativar conta
	@PostMapping("/api/conta/{idConta}/{idAgencia}/desativar")
	public ResponseEntity<ContaCorrente> desativar(@PathVariable("idConta") Long idConta, 
			@PathVariable("idAgencia") Long idAgencia) {
		 
		ContaCorrente contaCorrente = contaCorrenteService.desativar(idConta, idAgencia);
		
		return ResponseEntity.status(HttpStatus.OK).body(contaCorrente);
	}
	
	// Transferencia
	@PostMapping("/api/conta/transferencia")
	public ResponseEntity<BigDecimal> transferencia(@Valid @RequestBody TransferenciaDTO transferenciaDto){
		
		BigDecimal saldoAtual = contaCorrenteService.transferencia(transferenciaDto.getIdContaOrigem(), transferenciaDto.getIdAgenciaOrigem(), 
				transferenciaDto.getIdContaDestino(), transferenciaDto.getIdAgenciaDestino(), transferenciaDto.getValor());
				
		
		return ResponseEntity.status(HttpStatus.OK).body(saldoAtual);
		
	}  
}








