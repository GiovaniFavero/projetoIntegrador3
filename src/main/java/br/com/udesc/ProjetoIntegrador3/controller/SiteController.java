package br.com.udesc.ProjetoIntegrador3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {
	
	@RequestMapping("/")
	public String index() {
		return "Index";
	}
	
	@RequestMapping("/cidade")
	public String cidade() {
		return "Cidade";
	}
	
	@RequestMapping("/postos")
	public String postos() {
		return "Postos";
	}
	
	@RequestMapping("/exames")
	public String exames() {
		return "Exames";
	}
	
	@RequestMapping("/contato")
	public String contato() {
		return "Contato";
	}
	
	@RequestMapping("/resultado-consulta")
	public String resultadoConsulta() {
		return "ResultadoConsulta";
	}
	
}
