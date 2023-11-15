/**
 * 
 */
package br.com.jumbo.projeto_insulina.controllers;

import java.util.ArrayList;
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
import br.com.jumbo.projeto_insulina.dto.ObjetoRelatorioControleDose;
import br.com.jumbo.projeto_insulina.model.ControleDose;
import br.com.jumbo.projeto_insulina.model.Paciente;
import br.com.jumbo.projeto_insulina.repository.ControleDoseRepository;
import br.com.jumbo.projeto_insulina.repository.PacienteRepository;
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
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@ResponseBody
	@PostMapping(value = "**/salvaCrontroleDose")
	public ResponseEntity<ControleDose> salvarControleDose(@RequestBody @Valid ControleDose controleDose)
			throws ExceptionProjetoInsulina {

		if (controleDose.getDoseAplicada() == 0 || controleDose.getDoseAplicada() < 0) {

			throw new ExceptionProjetoInsulina("A dose a ser aplicada deve ser maior que zero.");

		}

		ControleDose controleDose1 = controleDoseService.salvarControleDose(controleDose);

		return new ResponseEntity<ControleDose>(controleDose1, HttpStatus.OK);
	}

	@ResponseBody
	@PostMapping(value = "**/relatorioDoseAplicada")
	public ResponseEntity<List<ObjetoRelatorioControleDose>> relatorioDoseAplicada(
			@Valid @RequestBody ObjetoRelatorioControleDose obejtoRequisicaoRelatorioDoseAplicada) 
					throws ExceptionProjetoInsulina {
				


		List<ObjetoRelatorioControleDose> retorno = new ArrayList<ObjetoRelatorioControleDose>();

		retorno = controleDoseService.relatorioDoseAplicada(obejtoRequisicaoRelatorioDoseAplicada);

		return new ResponseEntity<List<ObjetoRelatorioControleDose>>(retorno, HttpStatus.OK);

	}

}
