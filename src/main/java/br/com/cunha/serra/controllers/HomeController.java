package br.com.cunha.serra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView index(){
		System.out.println("Home - Carregando pagina");
		return new ModelAndView("hello-word");
	}
}
