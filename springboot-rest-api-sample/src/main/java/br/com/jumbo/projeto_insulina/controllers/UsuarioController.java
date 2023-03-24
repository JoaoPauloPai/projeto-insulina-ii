/**
 * 
 */
package br.com.jumbo.projeto_insulina.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jumbo.projeto_insulina.ExceptionProjetoInsulina;
import br.com.jumbo.projeto_insulina.model.Usuario;
import br.com.jumbo.projeto_insulina.repository.UsuarioRepository;
import br.com.jumbo.projeto_insulina.service.UsuarioService;

/**
 * @author João Paulo
 *
 *         6 de mar. de 2023 20:39:39
 */
@Controller
@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioService usuarioService;

	@ResponseBody
	@PostMapping(value = "**/salvarUsuario")
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario) throws ExceptionProjetoInsulina { 
																						

		//if (acesso.getId() == null) {
		// List<Acesso> acessos =
		// acessoRepository.buscaAcessoDesc(acesso.getDescricao().toUpperCase());

		// if (!acessos.isEmpty()) {
		// throw new ExceptionJumboSistemas("Já existe Acesso com a descrição: " +
		// acesso.getDescricao());
		// }
		// }

		if(usuario.getId() == null) {
			List<Usuario> usuarios =
					usuarioRepository.buscaUsuarioLogin(usuario.getLogin().toUpperCase());
			
			if(!usuarios.isEmpty()) {
				
				throw new ExceptionProjetoInsulina("Já exixte Login com essa descrição: " + usuario.getLogin());
				
			}
			List<Usuario> usuarios1 =
			usuarioRepository.buscaUsuarioEmail(usuario.getEmail().toUpperCase());
			if(!usuarios1.isEmpty()) { 
				throw new ExceptionProjetoInsulina("O email: "+ usuario.getEmail() + " já está cadastrado no Banco de Dados");
			}
		}
		
	Usuario	usuario1 = usuarioService.salvaSenhaCriptUsuario(usuario);
		
		
		
	

		return new ResponseEntity<Usuario>(usuario1, HttpStatus.OK);
	}

}
