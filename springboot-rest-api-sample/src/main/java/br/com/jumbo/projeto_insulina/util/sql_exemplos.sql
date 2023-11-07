p.nome as nomePaciente, p.sexo as sexo from paciente as p
inner join controle_dose as cd on cd.paciente_id = p.id
inner join usuario as u on u.id = p.usuario_id
and cd.data>= '2007-01-01' and cd.data <= '2008-08-09'

/**Realiza a consulta no banco de dados*/
select p.nome as nomePaciente, p.sexo as sexo, cd.data as dataDose, 
cd.dose_aplicada as doseAplicada from paciente as p
inner join controle_dose as cd on cd.paciente_id = p.id
inner join usuario as u on u.id = p.usuario_id
where cd.paciente_id = 10
and cd.data>= '2007-01-01' and cd.data <= '2010-08-09'

/**Teste para commit*/