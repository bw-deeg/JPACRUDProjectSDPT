package com.skilldistillery.bootcandy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.bootcandy.data.CandyDAO;
import com.skilldistillery.jpacandy.entities.Candy;

@Controller
public class CandyController {
	private CandyDAO dao;
	
	public CandyController(CandyDAO candyDAO) {
		this.dao = candyDAO;
	}
	
	@GetMapping({ "/", "home.do", "index.do" })
	public String index() {
	  return "home"; 
	}
	
	@GetMapping({"getCandy.do"})
	public String getCandyById( @RequestParam("candyId") int id, Model model) {
		Candy candy = dao.findById(id);
		model.addAttribute("candy", candy);
		return "candy/show";
	}
}
