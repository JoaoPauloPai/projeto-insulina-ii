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
import br.com.jumbo.projeto_insulina.model.Paciente;
import br.com.jumbo.projeto_insulina.model.Usuario;
import br.com.jumbo.projeto_insulina.repository.PacienteRepository;
import br.com.jumbo.projeto_insulina.repository.UsuarioRepository;

/**
 * @author João Paulo
 *
 * 28 de mar. de 2023
 * 20:45:02
 */
@Controller
@RestController
public class PacienteController {
	
	@Autowired
	 PacienteRepository pacienteRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	//@ResponseBody
//	@PostMapping(value = "**/salvarUsuario")
	/**public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario) throws ExceptionProjetoInsulina {

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

		Usuario usuario1 = usuarioService.salvaUsuario(usuario);

		return new ResponseEntity<Usuario>(usuario1, HttpStatus.OK);
	}*/
	
	@ResponseBody
	@PostMapping(value = "**/salvarPaciente")
	public ResponseEntity<Paciente> salvarPaciente(@RequestBody @Valid Paciente paciente) throws ExceptionProjetoInsulina {

		if (paciente.getId() == null) {
			
			List<Paciente> pacientes = pacienteRepository.buscaPaciente(paciente.getUsuario().getId());
		
			if(!pacientes.isEmpty()) {
				throw new ExceptionProjetoInsulina("Já exixte Paciente cadastrado para este usuario.");
				
				//System.out.println("Tem usuario, id: " + paciente.getUsuario().getId());
			
			}
			
			System.out.println("Não Tem usuario, id: " + paciente.getUsuario().getId());
			//paciente = usuarioRepository.consultaIdUsuario(paciente.getUsuario().getId());
		
	//	if(paciente.getUsuario().getId() == null) {
		//throw new ExceptionProjetoInsulina(
			//			"O Código: " + paciente.getUsuario().getId() + ", do usuario não foi encotrado no banco de dados");
		//}
		
		//}
		//if (pacienteRepository.findById(paciente.getUsuario().getId()).isPresent() == false) {
		//	throw new ExceptionProjetoInsulina(
		//			"O Código: " + paciente.getUsuario().getId() + ", do usuario não foi encotrado no banco de dados");
		}
		
	//	if (paciente.getId() == null) {
		
			//if (pacienteRepository.findById(paciente.getUsuario().getId()).isPresent() == true) {
				//throw new ExceptionProjetoInsulina(
					//	"O Código: " + paciente.getUsuario().getId() + ", já esta cadastrado.");
			//}
			//List<Paciente> pacientes = pacienteRepository.buscaPacienteUsuarioId(paciente.getUsuario());

			//if (!pacientes.isEmpty()) {

			//	throw new ExceptionProjetoInsulina("Já exixte Pacinte cadastrado para esse usuario: " + paciente.getUsuario());

			//}
	//	}
		

		//Usuario usuario1 = usuarioService.salvaSenhaCriptUsuario(usuario);
		
		Paciente pacienteSalvo = pacienteRepository.save(paciente);

		return new ResponseEntity<Paciente>(pacienteSalvo, HttpStatus.OK);
	
		
	
}
}


