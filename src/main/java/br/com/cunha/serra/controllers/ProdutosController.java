package br.com.cunha.serra.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cunha.serra.daos.ProdutoDAO;
import br.com.cunha.serra.models.BookType;
import br.com.cunha.serra.models.Produto;

@RequestMapping("/produtos")
@Controller
@Transactional
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO productDAO;
	
	@RequestMapping("/save")
	public String save(Produto produto){
	System.out.println("Cadastrando o produto : "+produto.toString());
	productDAO.save(produto);
	return "produto/ok";
	}
	
	@RequestMapping("/form")
	public ModelAndView form(){
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("types", BookType.values());
	return modelAndView;
	}

}
