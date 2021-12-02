package itau.com.br.financiamento.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import itau.com.br.financiamento.dto.PropostaDto;
import itau.com.br.financiamento.infrastructure.database.PropostaRepository;
import itau.com.br.financiamento.service.PropostaService;

@Service
public class PropostaServiceImpl implements PropostaService {
	
	private final PropostaRepository propostaRepository;
	
	public PropostaServiceImpl(PropostaRepository propostaRepository) {
		this.propostaRepository = propostaRepository;
	}

	@Override
	public List<PropostaDto> listarTodasPropostas() {
		propostaRepository.findAll();
		return null;
	}

}
