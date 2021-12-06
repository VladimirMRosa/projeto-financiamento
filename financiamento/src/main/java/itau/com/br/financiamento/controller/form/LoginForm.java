package itau.com.br.financiamento.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;

@Data
public class LoginForm {
	
	@CPF(message = "Dados do CPF incorreto") 
	@NotBlank(message = "Informe o CPF")
	private String cpf;
	@NotBlank(message = "informe sua senha")
	private String password;

	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(cpf, password);
	}

}
