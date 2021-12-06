package itau.com.br.financiamento.dto;

import itau.com.br.financiamento.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDto {
	
	private Long id;
	private String cpf;
	
	public static UsuarioDto converter(Usuario usuario) {
		UsuarioDto dto = new UsuarioDto();
		dto.setId(usuario.getId());
		dto.setCpf(usuario.getCpf());
		return dto;
	}

}

