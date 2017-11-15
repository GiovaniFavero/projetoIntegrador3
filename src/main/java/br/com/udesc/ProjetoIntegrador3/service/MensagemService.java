package br.com.udesc.ProjetoIntegrador3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.udesc.ProjetoIntegrador3.DAO.MensagemRepository;
import br.com.udesc.ProjetoIntegrador3.model.Mensagem;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	public void salvarMensagem(Mensagem mensagem) {
		mensagem.setNome(mensagem.getNome().replace("''", ""));
		mensagemRepository.save(mensagem);
	}

}
