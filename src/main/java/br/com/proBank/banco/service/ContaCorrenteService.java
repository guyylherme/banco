package br.com.proBank.banco.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.proBank.banco.entities.Agencia;
import br.com.proBank.banco.entities.ContaCorrente;
import br.com.proBank.banco.entities.Correntista;
import br.com.proBank.banco.entities.StatusConta;
import br.com.proBank.banco.repository.AgenciaRepository;
import br.com.proBank.banco.repository.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {
	 
	private ContaCorrenteRepository contaCorrenteRepository;
	private AgenciaRepository agenciaRepository;
	   
	public ContaCorrenteService(ContaCorrenteRepository contaCorrenteRepository, AgenciaRepository agenciaRepository) {
		this.contaCorrenteRepository = contaCorrenteRepository;
		this.agenciaRepository = agenciaRepository;
	}

	@Transactional
	public ContaCorrente salvarContaCorrente(ContaCorrente contaCorrente, Correntista correntista, Long idAgencia) {
		
		Agencia agencia = agenciaRepository.findById(idAgencia).get(); 
		contaCorrente.setCorrentista(correntista); 
		contaCorrente.setAgencia(agencia);
		
		return contaCorrenteRepository.save(contaCorrente);		
	}
	
	public Correntista findByCpf(String cpf) { 
		Correntista correntista = contaCorrenteRepository.findByCpf(cpf);  
		return correntista;
	}
	
	public ContaCorrente findByAgenciaEConta(Long idConta, Long idAgencia) { 
		return contaCorrenteRepository.findByIdAndIdAgencia(idConta, idAgencia);
	}
	
	public BigDecimal deposito(Long idConta, Long idAgencia, BigDecimal valor) {
		
		ContaCorrente contaCorrente = contaCorrenteRepository.findByIdAndIdAgencia(idConta, idAgencia);
		 
		contaCorrente.setSaldo(contaCorrente.getSaldo().add(valor));
		contaCorrenteRepository.save(contaCorrente);
		
		return contaCorrente.getSaldo();
	}
	
	public BigDecimal saque(Long idConta, Long idAgencia, BigDecimal valor) {
		
		ContaCorrente contaCorrente = contaCorrenteRepository.findByIdAndIdAgencia(idConta, idAgencia);
		if(contaCorrente.getSaldo().compareTo(valor) < 0) {
			System.out.println("Saldo insuficiente!");
			return null;
		}
 
		contaCorrente.setSaldo(contaCorrente.getSaldo().subtract(valor));
		contaCorrenteRepository.save(contaCorrente);
		
		return contaCorrente.getSaldo();
	}

	public ContaCorrente desativar(Long idConta, Long idAgencia) {
		ContaCorrente contaCorrente = contaCorrenteRepository.findByIdAndIdAgencia(idConta, idAgencia);
		contaCorrente.setAtiva(StatusConta.F);
		contaCorrenteRepository.save(contaCorrente);
		return contaCorrente;
	}

	public BigDecimal transferencia(Long idContaOrigem, Long idAgenciaOrigem, 
			Long idContaDestino, Long idAgenciaDestino, BigDecimal valor
			) {
		
		ContaCorrente contaCorrenteOrigem = contaCorrenteRepository.findByIdAndIdAgencia(idContaOrigem, idAgenciaOrigem);
		ContaCorrente contaCorrenteDestino = contaCorrenteRepository.findByIdAndIdAgencia(idContaDestino, idAgenciaDestino);
		if(contaCorrenteOrigem.getSaldo().compareTo(valor) < 0) {
			System.out.println("Saldo insuficiente!");
			return null;
		} 
		
		contaCorrenteOrigem.setSaldo(contaCorrenteOrigem.getSaldo().subtract(valor));
		contaCorrenteRepository.save(contaCorrenteOrigem);
		
		contaCorrenteDestino.setSaldo(contaCorrenteDestino.getSaldo().add(valor));
		contaCorrenteRepository.save(contaCorrenteDestino);
		
		return contaCorrenteOrigem.getSaldo();
	}
}





