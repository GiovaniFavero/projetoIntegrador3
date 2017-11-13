package br.com.udesc.ProjetoIntegrador3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.udesc.ProjetoIntegrador3.service.ConsultaExamesService;

@Controller
public class SiteController {
	
	@Autowired
	private ConsultaExamesService examesService;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("Index");
		mv.addObject("botaoMenu","index");
		return mv;
	}
	
	@RequestMapping("/cidade")
	public ModelAndView cidade() {
		ModelAndView mv = new ModelAndView("Cidade");
		mv.addObject("botaoMenu","cidade");
		return mv;
	}
	
	@RequestMapping("/postos")
	public ModelAndView postos() {
		ModelAndView mv = new ModelAndView("Postos");
		mv.addObject("botaoMenu","postos");
		return mv;
	}
	
	@RequestMapping("/exames")
	public ModelAndView exames() {
		ModelAndView mv = new ModelAndView("Exames");
		mv.addObject("botaoMenu","exames");
		return mv;
	}
	
	@RequestMapping("/contato")
	public ModelAndView contato() {
		ModelAndView mv = new ModelAndView("Contato");
		mv.addObject("botaoMenu","contato");
		return mv;
	}
	
	@RequestMapping("/resultado-consulta")
	public String resultadoConsulta() {
		return "ResultadoConsulta";
	}
	
}
