package itau.com.br.financiamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import itau.com.br.financiamento.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	String findByCpf(String cpf);

}
