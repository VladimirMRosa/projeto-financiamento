package itau.com.br.financiamento.controller.form;

import java.math.BigDecimal;

import itau.com.br.financiamento.infrastructure.database.PropostaRepository;
import itau.com.br.financiamento.model.Proposta;
import lombok.Data;

@Data
public class AtualizacaoPropostaForm {

	private BigDecimal valorFinanciado;
	private BigDecimal taxaJuros;
	
	public Proposta atualizar(Long id, PropostaRepository propostaRepository) {
		Proposta proposta = propostaRepository.getById(id);
		proposta.setTaxaJuros(this.taxaJuros);
		proposta.setValorFinanciado(this.valorFinanciado);
		return proposta;
	}

}
