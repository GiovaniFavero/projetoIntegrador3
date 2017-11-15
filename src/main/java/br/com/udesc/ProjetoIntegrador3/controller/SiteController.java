package br.com.udesc.ProjetoIntegrador3.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.udesc.ProjetoIntegrador3.DAO.PessoaFilter;
import br.com.udesc.ProjetoIntegrador3.model.Exame;
import br.com.udesc.ProjetoIntegrador3.model.Mensagem;
import br.com.udesc.ProjetoIntegrador3.service.ConsultaExamesService;
import br.com.udesc.ProjetoIntegrador3.service.MensagemService;
import groovyjarjarasm.asm.commons.Method;

@Controller
public class SiteController {
	
	@Autowired
	private ConsultaExamesService examesService;
	
	@Autowired
	private MensagemService mensagemService;
	
	@RequestMapping("/")
	public ModelAndView index()  {
		/*try {
			examesService.alimentaBanco();
		}catch(Exception e) {
			e.printStackTrace();
		}*/
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
		mv.addObject("filtro", new PessoaFilter());
		return mv;
	}
	
	@RequestMapping(value = "/contato")
	public ModelAndView contato() {
		ModelAndView mv = new ModelAndView("Contato");
		mv.addObject("botaoMenu","contato");
		mv.addObject("msg", new Mensagem());
		return mv;
	}
	
	@RequestMapping(value = "/contato/enviarMensagem", method = RequestMethod.POST)
	public String salvarMensagem(Mensagem mensagem, RedirectAttributes attributes) {
		attributes.addFlashAttribute("botaoMenu","contato");
		attributes.addFlashAttribute("msg", new Mensagem());
		try {
			mensagemService.salvarMensagem(mensagem);
		}catch(Exception e) {
		}
		return "redirect:/contato";
		
	}
	
	@RequestMapping("/consultar")
	public ModelAndView pesquisar(@ModelAttribute("filtro") PessoaFilter filtro) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date data = df.parse(filtro.getDataNascimento());
		List<Exame> exames = examesService.consultaExamesPessoa(filtro.getCpf(), data); 
		ModelAndView mv = new ModelAndView("ResultadoConsulta");
		mv.addObject("exames", exames);
		return mv;
	}
}
