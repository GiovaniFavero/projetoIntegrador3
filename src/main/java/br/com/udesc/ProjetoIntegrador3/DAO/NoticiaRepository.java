package br.com.udesc.ProjetoIntegrador3.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.udesc.ProjetoIntegrador3.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long>{
	
	
}
