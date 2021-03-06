package itau.com.br.financiamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
}