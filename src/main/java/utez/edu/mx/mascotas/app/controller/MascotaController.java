package utez.edu.mx.mascotas.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utez.edu.mx.mascotas.app.model.Caracter;
import utez.edu.mx.mascotas.app.model.Mascota;
import utez.edu.mx.mascotas.app.service.CaracterServiceImpl;
import utez.edu.mx.mascotas.app.service.MascotaServiceImpl;

@Controller
public class MascotaController {
	
	private ArrayList<Mascota> petList;
	@Autowired
	private CaracterServiceImpl serviceCaracter;
	
	@Autowired
	private MascotaServiceImpl ms;
	
	@GetMapping(value = {"/", "/mascota", "/mascota/{tipo}", "/mascota/{tipo}/{adopcion}"})
	public String findAllPets(Model model, @PathVariable Map<String, String> pathVariables) {
		
		petList =  new ArrayList<>();
		String tipo = pathVariables.get("tipo") != null ? pathVariables.get("tipo") : null;
		String adopcion = pathVariables.get("adopcion") != null ? pathVariables.get("adopcion") : null;
		String view = "index";
		
		if(tipo != null && tipo.equals("perro")) {
			if(adopcion == null) {
				petList.addAll(listFilter(1, ms.listar()));
			}else if(adopcion.equals("enadopcion")) {
				petList.addAll(listFilter(2, ms.listar()));
			}else {
				petList.addAll(listFilter(1, ms.listar()));
			}
			
			view = "view/dogs";
			
		}else if(tipo != null && tipo.equals("gato")) {
			if(adopcion == null) {
				petList.addAll(listFilter(3, ms.listar()));
			}else if(adopcion.equals("enadopcion")) {
				petList.addAll(listFilter(4, ms.listar()));
			}else {
				petList.addAll(listFilter(3, ms.listar()));
			}
			
			view = "view/cats";
		
		}else if(tipo != null && tipo.equals("enadopcion")) {
			petList.addAll(listFilter(5, ms.listar()));
		
		}else {
			petList.addAll(ms.listar());
		}
		
		model.addAttribute("tipo", tipo);
		model.addAttribute("petList", petList);
		return view;
	}
	
	@PostMapping(value = "/mascota/{tipo}/save")
	public String savePet(Model model, @PathVariable Map<String, String> pathVariables, Mascota mascota, RedirectAttributes redirectAttributes) {
		
		List<Caracter> lista = serviceCaracter.listarTodo();		
		String tipo = pathVariables.get("tipo") != null ? pathVariables.get("tipo") : null;
		String view = "";
		
		if(tipo != null && tipo.equals("perro")) {
			mascota.setId(petList.size()+1);
			mascota.setTipoMascota("Perro");
			mascota.setImagen("perro4.jpg");
			mascota.setDisponibleAdopcion(true);
			
			ms.guardar(mascota);
			petList = listFilter(1, ms.listar());
			
			view = "redirect:/mascota/perro";
			
		}else if(tipo != null && tipo.equals("gato")) {
			mascota.setId(petList.size()+1);
			mascota.setTipoMascota("Gato");
			mascota.setImagen("gato4.jpg");
			mascota.setDisponibleAdopcion(true);
			
			ms.guardar(mascota);
			petList = listFilter(3, ms.listar());
			
			view = "redirect:/mascota/gato";
		}
		
		model.addAttribute("listaCaracteres",lista);
		model.addAttribute("tipo", tipo);
		model.addAttribute("petList", petList);
		redirectAttributes.addFlashAttribute("msg_success","Registro Existoso");
		return view;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	// Método para filtrar y regresar la lista de mascotas
	public ArrayList<Mascota> listFilter(int op, ArrayList<Mascota> list) {
		
		ArrayList<Mascota> aux = new ArrayList<>();
		
		switch(op) {
		case 1:
			for(Mascota m: list) {
				if(m.getTipoMascota().equals("Perro")) {
					aux.add(m);
				}
			}
			break;
			
		case 2:
			for(Mascota m: list) {
				if(m.getTipoMascota().equals("Perro") && m.isDisponibleAdopcion()) {
					aux.add(m);
				}
			}
			break;
		
		case 3:
			for(Mascota m: list) {
				if(m.getTipoMascota().equals("Gato")) {
					aux.add(m);
				}
			}
			break;
			
		case 4:
			for(Mascota m: list) {
				if(m.getTipoMascota().equals("Gato") && m.isDisponibleAdopcion()) {
					aux.add(m);
				}
			}
			break;
			
		case 5:
			for(Mascota m: list) {
				if(m.isDisponibleAdopcion()) {
					aux.add(m);
				}
			}
			break;
			
		}
		
		return aux;
	}
}
