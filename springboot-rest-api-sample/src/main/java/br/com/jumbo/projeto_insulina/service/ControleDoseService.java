/**
 * 
 */
package br.com.jumbo.projeto_insulina.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import br.com.jumbo.projeto_insulina.dto.ObjetoRelatorioControleDose;
import br.com.jumbo.projeto_insulina.model.ControleDose;
import br.com.jumbo.projeto_insulina.repository.ControleDoseRepository;

/**
 * @author João Paulo
 *
 *         11 de set. de 2023 14:48:54
 */
@Service
public class ControleDoseService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ControleDoseRepository controleDoseRepository;

	/**
	 * @param controleDose
	 * @return
	 */
	public ControleDose salvarControleDose(ControleDose controleDose1) {

		ControleDose novoControleDose = new ControleDose();
		novoControleDose.setData(controleDose1.getData());
		novoControleDose.setDoseAplicada(controleDose1.getDoseAplicada());
		novoControleDose.setPaciente(controleDose1.getPaciente());

		controleDoseRepository.save(novoControleDose);

		return novoControleDose;
	}

	/**
	 * Este relatório permite saber as doses aplicada por pacientes e datas início e
	 * fim
	 * 
	 * @param obejtoRequisicaoRelatorioDoseAplicada
	 * @return
	 */
	public List<ObjetoRelatorioControleDose> relatorioDoseAplicada(
			ObjetoRelatorioControleDose obejtoRequisicaoRelatorioDoseAplicada) {

		List<ObjetoRelatorioControleDose> retorno = new ArrayList<ObjetoRelatorioControleDose>();

		String sql = "select p.nome as nomePaciente, "
				+ " p.sexo as sexo, "
				+ " cd.data as dataDose, "
				+ " cd.dose_aplicada as doseAplicada, "
				+ " cd.paciente_id as codigoPaciente "
				+ " from paciente as p "
				+ " inner join controle_dose as cd on cd.paciente_id = p.id "
				+ " inner join usuario as u on u.id = p.usuario_id ";
				sql += " where cd.paciente_id = " +
				obejtoRequisicaoRelatorioDoseAplicada.getCodigoPaciente();
				
				sql += " and cd.data>= '" +
				obejtoRequisicaoRelatorioDoseAplicada.getDataInicial()
				+ "' and cd.data <= '" +
				obejtoRequisicaoRelatorioDoseAplicada.getDataFinal() +"' ";
		

				retorno = jdbcTemplate.query(sql, new BeanPropertyRowMapper(ObjetoRelatorioControleDose.class));

		return retorno;
	}

}
