package com.grupo2.lucatinder.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.grupo2.lucatinder.model.Usuario;
import com.grupo2.lucatinder.service.ServiceGenerico;

@Controller("/")
public class ControlUsuario {
	
	@Autowired
	private ServiceGenerico<Usuario> service;
	
	@GetMapping("/crear/usuario")
	public String crear(Model model){
		model.addAttribute("usuario", new Usuario());
		return "usuarios/crearUsuario";
	}
	
	@PostMapping("/crear/usuario")
	public String guardar(@ModelAttribute Usuario usuario, Model model){
		System.out.println(usuario);
		 model.addAttribute("usuario" , service.crear(usuario));
		return "/usuarios/usuario";
	}
	
	@GetMapping("listar/usuarios")
	public String listar(Model model) {
		List<Usuario> lista = service.listar();
		model.addAttribute("usuarios", lista);
		return "/index";
	}
	
	@GetMapping("/listar/posiblesMatches/{id}")
	public String pedirPosiblesMatches(@PathVariable int id, Model model) {
		List<Usuario> lista = service.pedirPosiblesMatches(id);
		model.addAttribute("usuarios", lista);
		return "/listaMatches";
	}
	
	@PostMapping("/tratarResultadoMatch/{posibleMatch}")
	public String tratarResultadoMatch(@PathVariable boolean posibleMatch, @ModelAttribute Usuario usuario) {
		service.tratarResultadoMatch(posibleMatch, usuario);
		return "????????";
	}
	
	
}
	