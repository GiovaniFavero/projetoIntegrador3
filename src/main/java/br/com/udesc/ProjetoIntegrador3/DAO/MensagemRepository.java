package br.com.udesc.ProjetoIntegrador3.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.udesc.ProjetoIntegrador3.model.Exame;
import br.com.udesc.ProjetoIntegrador3.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long>{
	
	
	
}
