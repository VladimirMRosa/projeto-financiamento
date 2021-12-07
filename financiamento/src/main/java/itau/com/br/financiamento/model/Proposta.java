package itau.com.br.financiamento.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "propostas")
public class Proposta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valorFinanciamento;
	private BigDecimal taxaJuros;
	private LocalDate data = LocalDate.now();
   
	@ManyToOne
	private Cliente cliente;
	
	
	public Proposta() {
	}

	public Proposta(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
