package br.com.cunha.serra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(){
		System.out.println("Home - Carregando pagina");
		return "hello-word";
	}
}
