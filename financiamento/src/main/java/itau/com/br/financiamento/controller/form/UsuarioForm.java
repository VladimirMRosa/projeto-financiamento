package itau.com.br.financiamento.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import itau.com.br.financiamento.model.Usuario;
import lombok.Data;

@Data
public class UsuarioForm {
	
	@NotBlank(message = "Informe um nome")
	private String nome;
	@CPF(message = "Dados do CPF invalido") 
	@NotBlank(message = "Informe um CPF") 
	@Length(max = 11, message = "Digite somente os numeros")
	private String cpf;
	@NotBlank(message = "Informe uma Senha")
	private String password;
	

	public Usuario converter(Usuario usuario) {
		usuario.setCpf(this.cpf );
		usuario.setNome(this.nome);
		usuario.setPassword(this.password);
		return usuario;
	}

}
