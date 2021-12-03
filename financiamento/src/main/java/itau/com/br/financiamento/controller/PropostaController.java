package itau.com.br.financiamento.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import itau.com.br.financiamento.controller.form.AtualizacaoPropostaForm;
import itau.com.br.financiamento.controller.form.PropostaForm;
import itau.com.br.financiamento.dto.PropostaDto;
import itau.com.br.financiamento.infrastructure.database.ClienteRepository;
import itau.com.br.financiamento.infrastructure.database.PropostaRepository;
import itau.com.br.financiamento.infrastructure.database.UsuarioRepository;
import itau.com.br.financiamento.model.Proposta;

@RestController
@RequestMapping(value = "/proposta")
public class PropostaController {
	
	private final PropostaRepository propostaRepository;
	private final ClienteRepository clienteRepository;
	private final UsuarioRepository usuarioRepository;
	
	public PropostaController(PropostaRepository propostaRepository,UsuarioRepository usuarioRepository,ClienteRepository clienteRepository) {
		this.propostaRepository = propostaRepository;
		this.clienteRepository = clienteRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<PropostaDto> detalharProposta (@PathVariable Long id){
		Optional<Proposta> proposta = propostaRepository.findById(id);
		if(proposta.isPresent()) {
			return ResponseEntity.ok(new PropostaDto(proposta.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	    
	@PostMapping
	public ResponseEntity<PropostaDto> cadastrarProposta (@RequestBody @Valid PropostaForm form, UriComponentsBuilder uriBuilder) {
		System.out.println(form);
		Proposta proposta = form.converter(clienteRepository,usuarioRepository);
		propostaRepository.save(proposta);
		
		URI uri = uriBuilder.path("/proposta/{id}").buildAndExpand(proposta.getIdProposta()).toUri();
		return ResponseEntity.created(uri).body(new PropostaDto(proposta));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PropostaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPropostaForm form){
		Optional<Proposta> optional = propostaRepository.findById(id);
		if(optional.isPresent()) {
			Proposta proposta = form.atualizar(id, propostaRepository);
			return ResponseEntity.ok(new PropostaDto(proposta));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<PropostaDto> deletar(@PathVariable Long id){
		Optional<Proposta> optional = propostaRepository.findById(id);
		if(optional.isPresent()) {
			propostaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
