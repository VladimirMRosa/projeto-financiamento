package itau.com.br.financiamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itau.com.br.financiamento.dto.PropostaDto;
import itau.com.br.financiamento.service.PropostaService;

@RestController
@RequestMapping(value = "/proposta")
public class PropostaController {
	
	private final PropostaService propostaService;
	
	public PropostaController(PropostaService propostaService) {
		this.propostaService = propostaService;
	}
	
	@GetMapping(value = "/listar")
	public List<PropostaDto> listar(){
		propostaService.listarTodasPropostas();
		return null;
	}

}
