package itau.com.br.financiamento.controller.form;

import java.math.BigDecimal;

import itau.com.br.financiamento.model.Proposta;
import itau.com.br.financiamento.repository.PropostaRepository;
import lombok.Data;

@Data
public class AtualizacaoPropostaForm {
	
	private BigDecimal valorFinanciamento;
	private BigDecimal taxaJuros;

	public Proposta atualizar(Long id, PropostaRepository propostaRepository) {
		Proposta proposta = propostaRepository.getById(id);
		proposta.setTaxaJuros(this.taxaJuros);
		proposta.setValorFinanciamento(this.valorFinanciamento);
		return proposta;
	}
}
