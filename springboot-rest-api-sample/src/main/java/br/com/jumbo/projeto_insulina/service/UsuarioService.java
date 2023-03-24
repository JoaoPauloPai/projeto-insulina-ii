/**
 * 
 */
package br.com.jumbo.projeto_insulina.service;

import java.util.Calendar;

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

//	@Autowired
//private Usuario usuario;

	public Usuario salvaSenhaCriptUsuario(Usuario usuario1) {

		String senhaCript = new BCryptPasswordEncoder().encode(usuario1.getSenha());

		// usuarioPf = new Usuario();
		// usuarioPf.setDataAtualSenha(Calendar.getInstance().getTime());
		// usuarioPf.setEmpresa(pessoaFisica.getEmpresa());
		// usuarioPf.setPessoa(pessoaFisica);
		// usuarioPf.setLogin(pessoaFisica.getEmail());

		// String senha = "" + Calendar.getInstance().getTimeInMillis();
		// String senhaCript = new BCryptPasswordEncoder().encode(senha);

		// usuarioPf.setSenha(senhaCript);

		// usuarioPf = usuarioRepository.save(usuarioPf);

		Usuario novoUsuario = new Usuario();
		novoUsuario.setEmail(usuario1.getEmail());
		novoUsuario.setLogin(usuario1.getLogin());
		novoUsuario.setNome(usuario1.getNome());
		novoUsuario.setSenha(senhaCript);

		usuarioRepository.save(novoUsuario);

		return novoUsuario;
	}

}
