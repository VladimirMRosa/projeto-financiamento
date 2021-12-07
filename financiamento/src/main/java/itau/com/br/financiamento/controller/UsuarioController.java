package itau.com.br.financiamento.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itau.com.br.financiamento.controller.form.UsuarioForm;
import itau.com.br.financiamento.dto.UsuarioDto;
import itau.com.br.financiamento.model.Usuario;
import itau.com.br.financiamento.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}


	@GetMapping("/listarTodos")
	public ResponseEntity<List<Usuario>> listarTodos() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> listarPorId (@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);	
		if(usuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(usuario.get()));
		}
		return ResponseEntity.notFound().build();
	}

	  @PostMapping("/salvar")
	    public ResponseEntity<Usuario> salvar(@RequestBody @Valid UsuarioForm form) {
	        form.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
	       
	        Usuario usuario =  form.converter(new Usuario());
	        return ResponseEntity.ok(usuarioRepository.save(usuario));
	    }
}
