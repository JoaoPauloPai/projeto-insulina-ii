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
	
		
		
		//usuario.setEmail("josen@");
		//usuario.setLogin("login1");
	//	usuario.setNome("noem da silva");
		usuario1.setSenha(senhaCript);
		
		//usuarioRepository.save(usuario);

		return usuario1;
	}

}
