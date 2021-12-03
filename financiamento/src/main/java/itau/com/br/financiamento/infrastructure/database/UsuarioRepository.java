package itau.com.br.financiamento.infrastructure.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import itau.com.br.financiamento.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByCpf(String cpf);
	
}
