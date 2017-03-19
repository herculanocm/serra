package br.com.cunha.serra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/login")
	public String loginPage(){
		System.out.println("Controller AuthController loginPage()");
		return "auth/login";
	}
}
