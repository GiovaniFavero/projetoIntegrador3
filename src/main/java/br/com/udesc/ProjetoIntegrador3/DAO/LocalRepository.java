package br.com.udesc.ProjetoIntegrador3.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.udesc.ProjetoIntegrador3.model.Local;

public interface LocalRepository extends JpaRepository<Local, Long>{
	
	
}
