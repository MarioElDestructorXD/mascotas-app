package utez.edu.mx.mascotas.app.service;

import java.util.ArrayList;

import utez.edu.mx.mascotas.app.model.Mascota;

public interface IMascotasService {
	ArrayList<Mascota> listar();
	void guardar(Mascota mascota);
}
