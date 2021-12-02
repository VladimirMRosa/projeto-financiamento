package itau.com.br.financiamento.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itau.com.br.financiamento.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long>{

}
