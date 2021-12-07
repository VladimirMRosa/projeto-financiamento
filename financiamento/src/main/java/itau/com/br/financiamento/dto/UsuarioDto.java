package itau.com.br.financiamento.dto;

import java.util.List;
import java.util.stream.Collectors;

import itau.com.br.financiamento.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDto {
	
	private Long id;
	private String cpf;
	
	public UsuarioDto(Usuario usuario) {
		this.setId(usuario.getId());
		this.setCpf(usuario.getCpf());
	}

	public List<UsuarioDto> converteEmLista(List<Usuario> usuario){
		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
}

