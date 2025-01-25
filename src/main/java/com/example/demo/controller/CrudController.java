package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("items", crudService.get());
		return "manage";
	}
	
	@RequestMapping("/edit/{id}")
	public String page3(@PathVariable Long id,Model model) {
		CrudEntity item = crudService.getbyid(id);
		if(item != null) {
			model.addAttribute("item", item);
			return "edit";
		}
		return "redirect:/manage";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		crudService.deletebyid(id);
		return "redirect:/manage";
	}
}
