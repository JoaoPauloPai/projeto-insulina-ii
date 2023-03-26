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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

		if (usuario.getId() == null) {
			List<Usuario> usuarios = usuarioRepository.buscaUsuarioLogin(usuario.getLogin().toUpperCase());

			if (!usuarios.isEmpty()) {

				throw new ExceptionProjetoInsulina("Já exixte Login com essa descrição: " + usuario.getLogin());

			}
			List<Usuario> usuarios1 = usuarioRepository.buscaUsuarioEmail(usuario.getEmail().toUpperCase());
			if (!usuarios1.isEmpty()) {
				throw new ExceptionProjetoInsulina(
						"O email: " + usuario.getEmail() + " já está cadastrado no Banco de Dados");
			}
		}

		Usuario usuario1 = usuarioService.salvaSenhaCriptUsuario(usuario);

		return new ResponseEntity<Usuario>(usuario1, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "**/listaUsuario")
	public ResponseEntity<List<Usuario>> listaUsuario() {

		List<Usuario> usuario = usuarioRepository.findAll();

		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);

	}

	@ResponseBody
	@DeleteMapping(value = "**/deleteUsuarioPorId/{id}")
	public ResponseEntity<?> deleteUsuarioPorId(@PathVariable("id") Long id) throws ExceptionProjetoInsulina {

		usuarioRepository.deleteById(id);

		return new ResponseEntity("Usuario deletado por Id com sucesso!", HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "**/buscaUsuarioPorId/{id}")
	public ResponseEntity<Usuario> buscaUsuarioPorId(@PathVariable(name = "id") long id)
			throws ExceptionProjetoInsulina {

		Usuario usuario = usuarioRepository.findById(id).orElse(null);

		if (usuario == null) {

			throw new ExceptionProjetoInsulina("Não encotrado Usuario com código " + id);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

	}
	
	@ResponseBody
	@GetMapping(value = "**/buscaUsuarioPorLogin/{login}")
	public ResponseEntity<List<Usuario>> buscaUsuarioPorDesc(@PathVariable("login") String login) {

		List<Usuario> usuario = usuarioRepository.buscaUsuarioPorDesc(login.toUpperCase());

		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping(value = "**/buscaUsuarioPorNome/{nome}")
	public ResponseEntity<List<Usuario>> buscaUsuarioPorNome(@PathVariable("nome") String nome) throws ExceptionProjetoInsulina {

		List<Usuario> usuarios = usuarioRepository.buscaUsuarioPorNome(nome.toUpperCase());

		if (usuarios.isEmpty()) {

			throw new ExceptionProjetoInsulina("Não encotrado Usuário com o nome: " + nome);
		}
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

}
