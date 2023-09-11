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
import br.com.jumbo.projeto_insulina.model.ControleDose;
import br.com.jumbo.projeto_insulina.model.Usuario;
import br.com.jumbo.projeto_insulina.repository.ControleDoseRepository;
import br.com.jumbo.projeto_insulina.service.ControleDoseService;

/**
 * @author João Paulo
 *
 *         11 de set. de 2023 14:43:41
 */
@Controller
@RestController
public class ControleDoseController {

	@Autowired
	private ControleDoseService controleDoseService;

	@ResponseBody
	@PostMapping(value = "**/salvaCrontroleDose")
	public ResponseEntity<ControleDose> salvarControleDose(@RequestBody @Valid ControleDose controleDose)
			throws ExceptionProjetoInsulina {

		// if (controleDose.getId() == null) {
		// List<ControleDose> controleDoses =
		// usuarioRepository.buscaUsuarioLogin(usuario.getLogin().toUpperCase());
		// ControleDoseRepository.buscaControlerLogin

		// if (!usuarios.isEmpty()) {

		// throw new ExceptionProjetoInsulina("Já exixte Login com essa descrição: " +
		// usuario.getLogin());

		// }
		// List<Usuario> usuarios1 =
		// usuarioRepository.buscaUsuarioEmail(usuario.getEmail().toUpperCase());
		// if (!usuarios1.isEmpty()) {
		// throw new ExceptionProjetoInsulina(
		// "O email: " + usuario.getEmail() + " já está cadastrado no Banco de Dados");
		// }
//	}

		ControleDose controleDose1 = controleDoseService.salvarControleDose(controleDose);
		// Usuario usuario1 = usuarioService.salvaUsuario(usuario);

		return new ResponseEntity<ControleDose>(controleDose1, HttpStatus.OK);
	}

}
