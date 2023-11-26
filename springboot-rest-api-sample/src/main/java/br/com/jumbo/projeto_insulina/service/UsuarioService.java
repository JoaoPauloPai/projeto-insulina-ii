/**
 * 
 */
package br.com.jumbo.projeto_insulina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.jumbo.projeto_insulina.model.Usuario;
import br.com.jumbo.projeto_insulina.repository.UsuarioRepository;

/**
 * @author João Paulo
 *
 *         15 de mar. de 2023 20:41:34
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	

	public Usuario salvaSenhaCriptUsuario(Usuario usuario1) {

		String senhaCript = new BCryptPasswordEncoder().encode(usuario1.getSenha());

		Usuario novoUsuario = new Usuario();
		novoUsuario.setEmail(usuario1.getEmail());
		novoUsuario.setLogin(usuario1.getLogin());
		novoUsuario.setTipoSenha(usuario1.getTipoSenha());
		novoUsuario.setNome(usuario1.getNome());
		novoUsuario.setSenha(senhaCript);

		usuarioRepository.save(novoUsuario);

		return novoUsuario;
	}


	public Usuario salvaUsuario(Usuario usuario1) {

		Usuario novoUsuario = new Usuario();
		novoUsuario.setEmail(usuario1.getEmail());
		novoUsuario.setLogin(usuario1.getLogin());
		novoUsuario.setTipoSenha(usuario1.getTipoSenha());
		novoUsuario.setNome(usuario1.getNome());
		novoUsuario.setSenha(usuario1.getSenha());

		usuarioRepository.save(novoUsuario);

		return novoUsuario;
	}

}
