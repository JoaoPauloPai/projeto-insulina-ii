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
import br.com.jumbo.projeto_insulina.model.Paciente;
import br.com.jumbo.projeto_insulina.model.Usuario;
import br.com.jumbo.projeto_insulina.repository.PacienteRepository;
import br.com.jumbo.projeto_insulina.repository.UsuarioRepository;

/**
 * @author João Paulo
 *
 *         28 de mar. de 2023 20:45:02
 */
@Controller
@RestController
public class PacienteController {

	@Autowired
	PacienteRepository pacienteRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@ResponseBody
	@PostMapping(value = "**/salvarPaciente")
	public ResponseEntity<Paciente> salvarPaciente(@RequestBody @Valid Paciente paciente)
			throws ExceptionProjetoInsulina {

		if (paciente.getId() == null) {

			List<Paciente> pacientes = pacienteRepository.buscaPaciente(paciente.getUsuario().getId());

			if (!pacientes.isEmpty()) {
				throw new ExceptionProjetoInsulina("Já exixte Paciente cadastrado para este usuario.");

			}

			List<Usuario> usuarios = usuarioRepository.buscaUsuarioId(paciente.getUsuario().getId());

			if (usuarios.isEmpty()) {
				throw new ExceptionProjetoInsulina("O usuário com o Cod:" + paciente.getUsuario().getId()
						+ " não está cadastrado no banco de Dados.");
			}

		}

		Paciente pacienteSalvo = pacienteRepository.save(paciente);

		return new ResponseEntity<Paciente>(pacienteSalvo, HttpStatus.OK);

	}

	@ResponseBody
	@GetMapping(value = "**/listaPaciente")
	public ResponseEntity<List<Paciente>> listaPaciente() {

		List<Paciente> paciente = pacienteRepository.findAll();

		return new ResponseEntity<List<Paciente>>(paciente, HttpStatus.OK);

	}

	@ResponseBody
	@DeleteMapping(value = "**/deletePacientePorId/{id}")
	public ResponseEntity<?> deletePacientePorId(@PathVariable("id") Long id) throws ExceptionProjetoInsulina {

		List<Paciente> pacientes = pacienteRepository.buscaPacienteId(id);
		if (pacientes.isEmpty()) {
			throw new ExceptionProjetoInsulina("O Paciente com Id: " + id + " não existe no Banco de Dados");
		}

		pacienteRepository.deleteById(id);

		return new ResponseEntity("Usuario deletado por Id com sucesso!", HttpStatus.OK);
	}
}
