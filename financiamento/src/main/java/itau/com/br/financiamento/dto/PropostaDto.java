package itau.com.br.financiamento.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import itau.com.br.financiamento.model.Cliente;
import itau.com.br.financiamento.model.Proposta;
import itau.com.br.financiamento.model.Usuario;
import lombok.Data;

@Data
public class PropostaDto {
	
	private BigDecimal taxaJuros;
	private BigDecimal valorFinancioado;
	private Usuario usuario;
	private Cliente cliente;

	public PropostaDto(Proposta proposta) {
		this.cliente = proposta.getCliente();
		this.usuario = proposta.getUsuario();
		this.taxaJuros = proposta.getTaxaJuros();
		this.valorFinancioado = proposta.getValorFinanciado();
	}
	
	
	public static List<PropostaDto> converter(List<Proposta> proposta){
		return proposta.stream().map(PropostaDto::new).collect(Collectors.toList());
	}
	
}
