package itau.com.br.financiamento.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
	
	@RequestMapping
	public String teste() {
		String teste = "Ola";
		return teste;
	}

}
