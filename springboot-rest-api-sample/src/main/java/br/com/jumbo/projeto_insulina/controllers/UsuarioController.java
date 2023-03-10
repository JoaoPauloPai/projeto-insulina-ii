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

import br.com.jumbo.projeto_insulina.model.Usuario;
import br.com.jumbo.projeto_insulina.repository.UsuarioRepository;

/**
 * @author João Paulo
 *
 * 6 de mar. de 2023
 * 20:39:39
 */
@Controller
@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@ResponseBody
	@PostMapping(value = "**/salvarUsuario")
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario){ //throws ExceptionJumboSistemas {

		//if (acesso.getId() == null) {
		//	List<Acesso> acessos = acessoRepository.buscaAcessoDesc(acesso.getDescricao().toUpperCase());

		//	if (!acessos.isEmpty()) {
			//	throw new ExceptionJumboSistemas("Já existe Acesso com a descrição: " + acesso.getDescricao());
			//}
		//}

		Usuario usuario2 = usuarioRepository.save(usuario);

		return new ResponseEntity<Usuario>(usuario2, HttpStatus.OK);
	}

}
