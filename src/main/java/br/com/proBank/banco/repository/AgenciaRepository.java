package br.com.proBank.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.proBank.banco.entities.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
	
	
}
