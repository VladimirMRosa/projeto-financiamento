package itau.com.br.financiamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import itau.com.br.financiamento.dto.UsuarioDto;
import itau.com.br.financiamento.model.Usuario;
import itau.com.br.financiamento.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioController(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}


	@GetMapping("/{id}")
	public List<UsuarioDto> listar (@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.stream().map(UsuarioDto::converter).toList();

	}
}
