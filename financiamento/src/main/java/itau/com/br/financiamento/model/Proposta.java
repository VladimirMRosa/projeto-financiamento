package itau.com.br.financiamento.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Proposta")
public class Proposta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProposta;
	private BigDecimal taxaJuros;
	private BigDecimal valorFinanciado;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Usuario usuario;
	
	
	public Proposta(BigDecimal taxaJuros, BigDecimal valorFinanciado, Cliente cliente) {
		this.taxaJuros = taxaJuros;
		this.valorFinanciado = valorFinanciado;
		this.cliente = cliente;
	}

	
	
}
