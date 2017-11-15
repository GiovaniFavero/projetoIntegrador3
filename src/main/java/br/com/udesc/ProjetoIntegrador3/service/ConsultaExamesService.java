package br.com.udesc.ProjetoIntegrador3.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.udesc.ProjetoIntegrador3.model.Exame;
import br.com.udesc.ProjetoIntegrador3.model.Local;
import br.com.udesc.ProjetoIntegrador3.model.Medico;
import br.com.udesc.ProjetoIntegrador3.model.Pessoa;
import br.com.udesc.ProjetoIntegrador3.DAO.ExameRepository;
import br.com.udesc.ProjetoIntegrador3.DAO.LocalRepository;
import br.com.udesc.ProjetoIntegrador3.DAO.MedicoRepository;
import br.com.udesc.ProjetoIntegrador3.DAO.PessoaRepository;

@Service
public class ConsultaExamesService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private LocalRepository localRepository;
	@Autowired
	private ExameRepository exameRepository;
	
	public List<Exame> consultaExamesPessoa(String cpf, Date dataNasc){
		try {
			Pessoa pessoa = pessoaRepository.findByCpfAndDataNascimento(cpf, dataNasc);
			return pessoa.getExames();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void alimentaBanco() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Pessoa p1 = new Pessoa("Giovani Fávero", "09030442930" , df.parse("09/12/1997"));
		Pessoa p2 = new Pessoa("Antonio da Silva", "09365874122" , df.parse("02/07/1995"));
		Pessoa p3 = new Pessoa("Carlos Santos", "12435896588" , df.parse("07/02/1992"));
		Pessoa p4 = new Pessoa("Cesar Augusto", "12345695465" , df.parse("08/11/1998"));
		pessoaRepository.save(p1);
		pessoaRepository.save(p2);
		pessoaRepository.save(p3);
		pessoaRepository.save(p4);
		
		Local local = new Local("Posto de Saúde");
		localRepository.save(local);
		
		Medico m1 = new Medico("123", "Juarez Santos", "Cancer");
		Medico m2 = new Medico("321", "Carlos Andrade", "Estomago");
		medicoRepository.save(m1);
		medicoRepository.save(m2);
		List<Exame> exames = new ArrayList<>();
		exames.add(new Exame(p1, df.parse("05/11/2017"), local, m1));
		exames.add(new Exame(p1, df.parse("06/12/2017"), local, m2));
		exames.add(new Exame(p1, df.parse("05/09/2017"), local, m1));
		exames.add(new Exame(p1, df.parse("04/02/2017"), local, m2));
		exames.add(new Exame(p2, df.parse("03/02/2017"), local, m1));
		exames.add(new Exame(p2, df.parse("02/03/2017"), local, m2));
		exames.add(new Exame(p2, df.parse("07/01/2017"), local, m1));
		exames.add(new Exame(p2, df.parse("04/01/2017"), local, m2));
		exames.add(new Exame(p3, df.parse("01/08/2017"), local, m1));
		exames.add(new Exame(p3, df.parse("02/09/2017"), local, m2));
		exames.add(new Exame(p3, df.parse("04/10/2017"), local, m1));
		exames.add(new Exame(p3, df.parse("09/11/2017"), local, m2));
		exames.add(new Exame(p4, df.parse("07/10/2017"), local, m1));
		exames.add(new Exame(p4, df.parse("03/05/2017"), local, m2));
		exames.add(new Exame(p4, df.parse("02/07/2017"), local, m1));
		exames.add(new Exame(p4, df.parse("05/12/2017"), local, m2));
		for(Exame e : exames) {
			exameRepository.save(e);
		}
		
		
	}

}
