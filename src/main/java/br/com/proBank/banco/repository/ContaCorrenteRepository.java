package br.com.proBank.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.proBank.banco.entities.ContaCorrente;
import br.com.proBank.banco.entities.Correntista;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

	@Query("SELECT c FROM ContaCorrente c WHERE c.agencia.id = :idAgencia and c.id = :id")
	ContaCorrente findByIdAndIdAgencia(Long id, Long idAgencia);
	
	@Query("SELECT c FROM Correntista c WHERE c.cpf = :cpf")
	Correntista findByCpf(String cpf);
	
	@Query("SELECT c FROM ContaCorrente c WHERE c.correntista.id = :idCorrentista")
	ContaCorrente findByIdCorrentista(Long idCorrentista);
		  
	
}
