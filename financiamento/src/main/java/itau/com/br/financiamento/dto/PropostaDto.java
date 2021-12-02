package itau.com.br.financiamento.dto;

import java.math.BigDecimal;

import itau.com.br.financiamento.model.Cliente;
import itau.com.br.financiamento.model.Usuario;
import lombok.Data;

@Data
public class PropostaDto {
	
	private BigDecimal taxaJuros;
	private BigDecimal valorFinancioado;
	private Usuario usuario;
	private Cliente cliente;

}
