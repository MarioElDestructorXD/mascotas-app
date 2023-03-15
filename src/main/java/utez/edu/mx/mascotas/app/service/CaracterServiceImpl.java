package utez.edu.mx.mascotas.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import utez.edu.mx.mascotas.app.model.Caracter;

@Service
public class CaracterServiceImpl implements ICaracterService {

	private List<Caracter> lista = null;

	public CaracterServiceImpl() {
		lista = new LinkedList<>();
		lista.add(new Caracter(1, "Activo"));
		lista.add(new Caracter(2, "Independiente"));
		lista.add(new Caracter(3, "Jugueton"));
		lista.add(new Caracter(4, "Protector"));
		lista.add(new Caracter(5, "Ruidoso"));
		lista.add(new Caracter(6, "Timido"));
		lista.add(new Caracter(7, "Tranquilo"));
		lista.add(new Caracter(8, "Amoroso"));

	}

	@Override
	public List<Caracter> listarTodo() {
		return lista;
	}
}
