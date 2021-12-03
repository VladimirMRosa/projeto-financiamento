package itau.com.br.financiamento.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import itau.com.br.financiamento.model.Usuario;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authenticate) {
		Usuario logado = (Usuario) authenticate.getPrincipal();
		Date hoje = new Date();
		Date dataExpiração = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("API de financiamento Itau")
				.setSubject(logado.getIdUsuario().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiração)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact()
				;
	}

}
