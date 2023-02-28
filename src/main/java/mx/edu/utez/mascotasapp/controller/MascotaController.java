package mx.edu.utez.mascotasapp.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.utez.mascotasapp.model.Mascota;

@Controller
@RequestMapping(value = "/mascotas")
public class MascotaController {
    @GetMapping(value = {"/listar", "/listar/{estado}", "/listar/{mascota}/{estado}"})
    public String listar(Model modelo, @PathVariable Map<String, String> pathVars) {
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

        String tipoMascota = pathVars.get("mascota");
        String estado = pathVars.get("estado");
        boolean estadoConversion = Boolean.parseBoolean(estado);
        if (tipoMascota != null) {
            if (tipoMascota.toLowerCase().equals("gato")) {
                if (estadoConversion) {
                    lista = lista
                            .stream()
                            .filter(x -> x.getDiponibleAdopcion() == true && x.getTipoMascota().toLowerCase().equals("gato"))
                            .collect(Collectors.toList());
                } else {
                    lista = lista
                            .stream()
                            .filter(x -> x.getTipoMascota().toLowerCase().equals("gato"))
                            .collect(Collectors.toList());
                }
            } else if (tipoMascota.toLowerCase().equals("perro")) {
                if (estadoConversion) {
                    lista = lista
                            .stream()
                            .filter(x -> x.getDiponibleAdopcion() == true && x.getTipoMascota().toLowerCase().equals("perro"))
                            .collect(Collectors.toList());
                } else {
                    lista = lista
                            .stream()
                            .filter(x -> x.getTipoMascota().toLowerCase().equals("perro"))
                            .collect(Collectors.toList());
                }
            }
            System.out.println(lista);
            modelo.addAttribute("listaMascotas", lista);
            return "index";
        } else {
            if (estadoConversion) {
                lista = lista
                        .stream()
                        .filter(x -> x.getDiponibleAdopcion() == true)
                        .collect(Collectors.toList());
            }
            modelo.addAttribute("listaMascotas", lista);
            return "index";
        }
    }
}