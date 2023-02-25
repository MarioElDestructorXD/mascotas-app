package mx.edu.utez.mascotasapp.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.edu.utez.mascotasapp.model.Publicacion;

@Controller
@RequestMapping("/publicacion")
public class PublicacionController {
	
	List<Publicacion> lista = new LinkedList<>();
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("listPublicaciones", lista);
		return "listPublicaciones";
	}
	
	@PostMapping("/guardar")
	public String guardar( 
			@RequestParam("titulo") String titulo, 
			@RequestParam("contenido") String contenido, 
			@RequestParam("estatus") boolean estatus,
			Model modelo) {
		
		lista.add(new Publicacion(titulo,contenido,estatus));
		modelo.addAttribute("listPublicaciones", lista);
		return "listPublicaciones";
	}
}
