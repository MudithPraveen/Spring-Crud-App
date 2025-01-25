package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entity.CrudEntity;
import com.example.demo.service.CrudService;

@Controller
public class CrudController {

	@Autowired
	CrudService crudService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute CrudEntity item) {
		crudService.save(item);
		return "redirect:/manage";
	}
	
	@RequestMapping("/add")
	public String page1(Model model) {
		model.addAttribute("item", new CrudEntity());
		return "add";
	}
	
	@RequestMapping("/manage")
	public String page2(Model model) {
		model.addAttribute("item", crudService.get());
		return "add";
	}
	
}
