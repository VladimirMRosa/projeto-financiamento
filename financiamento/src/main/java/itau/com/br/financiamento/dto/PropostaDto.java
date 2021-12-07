package itau.com.br.financiamento.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import itau.com.br.financiamento.model.Cliente;
import itau.com.br.financiamento.model.Proposta;


public class PropostaDto {
	
	private BigDecimal taxaJuros;
	private BigDecimal valorFinanciamento;
	private Cliente cliente;
	

	public PropostaDto(Proposta proposta) {
		Cliente dadoCliente = new Cliente();
		dadoCliente.setId(proposta.getCliente().getId());
		dadoCliente.setCpf(proposta.getCliente().getCpf());
		dadoCliente.setNome(proposta.getCliente().getNome());
		this.cliente = dadoCliente;
		this.taxaJuros = proposta.getTaxaJuros();
		this.valorFinanciamento = proposta.getValorFinanciamento();
	}


	public static List<PropostaDto> converter(List<Proposta> proposta){
		return proposta.stream().map(PropostaDto::new).collect(Collectors.toList());
	}


	public BigDecimal getTaxaJuros() {
		return taxaJuros;
	}


	public BigDecimal getValorFinanciamento() {
		return valorFinanciamento;
	}


	public Cliente getCliente() {
		return cliente;
	}
	
	
}
