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
import br.com.jumbo.projeto_insulina.repository.PacienteRepository;

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
	
	@ResponseBody
	@PostMapping(value = "**/salvarPaciente")
	public ResponseEntity<Paciente> salvarPaciente(@RequestBody @Valid Paciente paciente) throws ExceptionProjetoInsulina {

		if (paciente.getId() == null) {
			
			List<Paciente> pacientes = pacienteRepository.buscaPacienteUsuarioId(paciente.getUsuario());

			if (!pacientes.isEmpty()) {

				throw new ExceptionProjetoInsulina("Já exixte Pacinte cadastrado para esse usuario: " + paciente.getUsuario());

			}
		}
		

		//Usuario usuario1 = usuarioService.salvaSenhaCriptUsuario(usuario);
		
		Paciente pacienteSalvo = pacienteRepository.save(paciente);

		return new ResponseEntity<Paciente>(pacienteSalvo, HttpStatus.OK);
	
		
	
}
}


