package br.com.udesc.ProjetoIntegrador3.DAO;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.udesc.ProjetoIntegrador3.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	public Pessoa findByCpfAndDataNascimento(String cpf, Date dataNascimento);
	
}
