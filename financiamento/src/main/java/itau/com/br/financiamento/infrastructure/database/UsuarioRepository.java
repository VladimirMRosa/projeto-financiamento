package itau.com.br.financiamento.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

import itau.com.br.financiamento.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	String findByCpf(String cpf);
	
}
