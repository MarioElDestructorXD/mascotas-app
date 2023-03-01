package mx.edu.utez.mascotasapp.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mx.edu.utez.mascotasapp.model.Mascota;

@Controller
@RequestMapping(value = "/mascotas")
public class MascotaController {

    List<Mascota> listaGato = new LinkedList<>();
    List<Mascota> listaPerro = new LinkedList<>();

    @GetMapping(value = {"/listar", "/listar/{estado}", "/listar/{mascota}/{estado}"})
    public String listar(Model modelo, @PathVariable Map<String, String> pathVars) {
        List<Mascota> lista = new LinkedList<>();
        Mascota mascota1 = new Mascota("Bombón", 1, "Es un buen gatito", "Gato", "gato1.jpg", true);
        lista.add(mascota1);
        Mascota mascota2 = new Mascota("Botas", 1, "Es muy juguetona", "Gato", "gato2.png", false);
        lista.add(mascota2);
        Mascota mascota3 = new Mascota("Zimba", 1, "Es un buen gatito", "Gato", "gato3.png", false);
        lista.add(mascota3);
        Mascota mascota4 = new Mascota("Jose", 1, "Es lindo", "Perro", "perro1.jpg", true);
        lista.add(mascota4);
        Mascota mascota5 = new Mascota("Marcos", 1, "Imperactivo", "Perro", "perro2.jpg", true);
        lista.add(mascota5);
        Mascota mascota6 = new Mascota("Alegria", 1, "Dormilon", "Perro", "perro3.jpg", false);
        lista.add(mascota6);

        String tipoMascota = pathVars.get("mascota");
        String estado = pathVars.get("estado");
        boolean estadoConversion = Boolean.parseBoolean(estado);

        if (tipoMascota != null) {
            if (tipoMascota.equals("Gato")) {
                if (estadoConversion) {
                    lista = lista
                            .stream()
                            .filter(x -> x.getDiponibleAdopcion() == true && x.getTipoMascota().equals("Gato"))
                            .collect(Collectors.toList());

                } else {
                    lista = lista
                            .stream()
                            .filter(x -> x.getTipoMascota().equals("Gato"))
                            .collect(Collectors.toList());
                    listaGato = lista
                            .stream()
                            .filter(x -> x.getTipoMascota().equals("Gato"))
                            .collect(Collectors.toList());
                    ;
                    System.out.println(listaGato);
                }
                modelo.addAttribute("listaMascotas", lista);
                return "listarGatos";
            } else if (tipoMascota.equals("Perro")) {
                if (estadoConversion) {
                    lista = lista
                            .stream()
                            .filter(x -> x.getDiponibleAdopcion() == true && x.getTipoMascota().equals("Perro"))
                            .collect(Collectors.toList());
                } else {
                    lista = lista
                            .stream()
                            .filter(x -> x.getTipoMascota().equals("Perro"))
                            .collect(Collectors.toList());
                    listaPerro = lista
                            .stream()
                            .filter(x -> x.getTipoMascota().equals("Perro"))
                            .collect(Collectors.toList());
                    ;
                    System.out.println(listaPerro);
                }
                modelo.addAttribute("listaMascotas", lista);
                return "listarPerros";
            }
        } else {
            if (estadoConversion) {
                lista = lista
                        .stream()
                        .filter(x -> x.getDiponibleAdopcion() == true)
                        .collect(Collectors.toList());
                modelo.addAttribute("listaMascotas", lista);
            } else {
                modelo.addAttribute("listaMascotas", lista);
            }

        }
        return "index";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam("nombre") String nombre,
                          @RequestParam("edad") Integer edad,
                          @RequestParam("descripcion") String descripcion,
                          @RequestParam("tipoMascota") String tipoMascota,
                          @RequestParam("estado") boolean disponibleAdopcion,
                          Model modelo){
        Mascota mascota = new Mascota();
        mascota.setNombre(nombre);
        mascota.setEdad(edad);
        mascota.setDescripcion(descripcion);
        mascota.setTipoMascota(tipoMascota);
        mascota.setDiponibleAdopcion(disponibleAdopcion);
        if(tipoMascota.equals("Perro")) {
            mascota.setImagen("perro1.jpg");
            listaPerro.add(mascota);
            modelo.addAttribute("listaMascotas", listaPerro);
            return "listarPerros";
        }else {
            mascota.setImagen("gato.jpg");
            listaGato.add(mascota);
            modelo.addAttribute("listaMascotas", listaGato);
            return "listarGatos";
        }
    }
}
