package br.com.udesc.ProjetoIntegrador3.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.udesc.ProjetoIntegrador3.model.Exame;
import br.com.udesc.ProjetoIntegrador3.model.Pessoa;
import br.com.udesc.ProjetoIntegrador3.DAO.ExameRepository;
import br.com.udesc.ProjetoIntegrador3.DAO.PessoaRepository;

@Service
public class ConsultaExamesService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Exame> consultaExamesPessoa(String cpf, Date dataNasc){
		Pessoa pessoa = pessoaRepository.findByCpfAndDataNascimento(cpf, dataNasc);
		return pessoa.getExames();
	}

}
