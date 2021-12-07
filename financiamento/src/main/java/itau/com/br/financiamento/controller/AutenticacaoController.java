package itau.com.br.financiamento.controller;



import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itau.com.br.financiamento.config.security.TokenService;
import itau.com.br.financiamento.controller.form.LoginForm;
import itau.com.br.financiamento.dto.TokenDto;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	private AuthenticationManager authenticationManager;
	private TokenService tokenService;

	public AutenticacaoController(AuthenticationManager authenticationManager,TokenService tokenService) {
		this.authenticationManager = authenticationManager;
		this.tokenService = tokenService;
	}



	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authenticate = authenticationManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
