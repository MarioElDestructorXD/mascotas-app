package mx.edu.utez.mascotasapp.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.utez.mascotasapp.model.Mascota;

@Controller
@Configuration
@RequestMapping(value = "/mascotas")
public class MascotaController {

    @GetMapping("/listar")
    public String listar(Model modelo) {
        List<Mascota> lista = new LinkedList<>();
        Mascota mascota1 = new Mascota("Bombón", 1, "Es un buen gatito", "Gato", "gato1.jpg", true);
        lista.add(mascota1);
        Mascota mascota2 = new Mascota("Botas", 1, "Es muy juguetona", "Gato", "gato2.png", false);
        lista.add(mascota2);
        Mascota mascota3 = new Mascota("Zimba", 1, "Es un buen gatito", "Gato", "gato3.png", false);
        lista.add(mascota3);
        Mascota mascota4 = new Mascota("Zimba", 1, "Es un buen gatito", "Perro", "perro1.jpg", true);
        lista.add(mascota4);
        Mascota mascota5 = new Mascota("Zimba", 1, "Es un buen gatito", "Perro", "perro2.jpg", true);
        lista.add(mascota5);
        Mascota mascota6 = new Mascota("Zimba", 1, "Es un buen gatito", "Perro", "perro3.jpg", false);
        lista.add(mascota6);
        modelo.addAttribute("listaMascotas", lista);
        return "index";
    }
    
    @GetMapping("/listar/1")
    public String perro(Model modelo) {
        List<Mascota> lista = new LinkedList<>();
        Mascota mascota4 = new Mascota("Zimba", 1, "Es un buen gatito", "Perro", "perro1.jpg", true);
        lista.add(mascota4);
        Mascota mascota5 = new Mascota("Zimba", 1, "Es un buen gatito", "Perro", "perro2.jpg", true);
        lista.add(mascota5);
        Mascota mascota6 = new Mascota("Zimba", 1, "Es un buen gatito", "Perro", "perro3.jpg", false);
        lista.add(mascota6);
        modelo.addAttribute("listaMascotas", lista);
        return "index";
    }
    
    @GetMapping("/listar/2")
    public String gato(Model modelo) {
        List<Mascota> lista = new LinkedList<>();
        Mascota mascota1 = new Mascota("Bombón", 1, "Es un buen gatito", "Gato", "gato1.jpg", true);
        lista.add(mascota1);
        Mascota mascota2 = new Mascota("Botas", 1, "Es muy juguetona", "Gato", "gato2.png", false);
        lista.add(mascota2);
        Mascota mascota3 = new Mascota("Zimba", 1, "Es un buen gatito", "Gato", "gato3.png", false);
        lista.add(mascota3);
        modelo.addAttribute("listaMascotas", lista);
        return "index";
    }
}