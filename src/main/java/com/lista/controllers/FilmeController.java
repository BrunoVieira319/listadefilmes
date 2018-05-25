package com.lista.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lista.models.Filme;
import com.lista.repository.FilmesRepository;

@Controller
public class FilmeController {
	
	@Autowired
	private FilmesRepository filmeRepository;
	
	@RequestMapping(value="/adicionarFilme", method=RequestMethod.GET)
	public String form() {
		return "formFilme";
	}
	
	@RequestMapping(value="/adicionarFilme", method=RequestMethod.POST)
	public String form(Filme filme) {
		
		filmeRepository.save(filme);
		
		return "redirect:/filmes";
	}
	
	@RequestMapping("/filmes")
	public ModelAndView listaDeFilmes() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Filme> filmes = filmeRepository.findAll();
		mv.addObject("filmes", filmes);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deletarFilme(@RequestParam long id) {
		Filme filme = filmeRepository.findById(id);
		filmeRepository.delete(filme);
		return "redirect:/filmes";
	}
}
