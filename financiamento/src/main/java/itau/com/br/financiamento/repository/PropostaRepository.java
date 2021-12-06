package itau.com.br.financiamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itau.com.br.financiamento.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long>{
	
	Optional<Proposta> findById(Long id);

}
