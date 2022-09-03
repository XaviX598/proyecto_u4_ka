package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private IPersonaService iPersonaService;
	
	//GET
	@GetMapping("/buscar")
	//ponemos Srting porque va a mandar una vista
	public String buscarTodos(Model modelo){
		List<Persona> lista = this.iPersonaService.buscarTodos();
		modelo.addAttribute("personas", lista); //"personas es el nombre del .html en templates
		return "vistaListaPersonas";
	}

}
