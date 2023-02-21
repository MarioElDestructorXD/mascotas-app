package mx.edu.utez.mascotasapp.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mx.edu.utez.mascotasapp.model.Mascota;

@Controller
public class MascotaController {
	
	@GetMapping("/add")
	public String agregarMascota(Model model) {
		
		List<Mascota> lista = new LinkedList<>();
		
		Mascota mascota = new Mascota();
		mascota.setNombre("Billy");
		mascota.setEdad(10);
		mascota.setTipoMascota("p");
		mascota.setDescripcion("Chihuahuenio");
		mascota.setDiponibleAdopcion(true);
		mascota.setImagen("perro1.jpg");
		
		lista.add(mascota);
		
		return "2";
	}

}
