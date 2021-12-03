package itau.com.br.financiamento.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import itau.com.br.financiamento.infrastructure.database.ClienteRepository;
import itau.com.br.financiamento.infrastructure.database.UsuarioRepository;
import itau.com.br.financiamento.model.Cliente;
import itau.com.br.financiamento.model.Proposta;
import lombok.Data;

@Data
public class PropostaForm {
	
	private BigDecimal valorFinanciado;
	private BigDecimal taxaJuros;
	@NotBlank(message = "Campo CPF é obrigatorio")
	@CPF(message = "Dados do CPF invalido")
	private String cpfCliente;
	@NotBlank(message = "Campo CPF é obrigatorio")
	@CPF(message = "Dados do CPF invalido")
	private String cpfVendedor;
	
	public Proposta converter(ClienteRepository clienteRepository, UsuarioRepository usuarioRepository) {
		Cliente cliente = new Cliente();
		cliente.setCpf(clienteRepository.findByCpf(cpfCliente));
		return new Proposta( taxaJuros, valorFinanciado, cliente);
	}

}
