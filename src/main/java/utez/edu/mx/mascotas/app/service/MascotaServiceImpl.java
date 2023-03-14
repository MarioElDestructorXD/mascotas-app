package utez.edu.mx.mascotas.app.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import utez.edu.mx.mascotas.app.model.Mascota;

@Service
public class MascotaServiceImpl implements IMascotasService {
	
	private ArrayList<Mascota> petList = new ArrayList<>();

	@Override
	public ArrayList<Mascota> listar() {
		if(petList.isEmpty()) {
			llenarLista();
		}
		return petList;
	}
	
	@Override
	public void guardar(Mascota mascota) {
		petList.add(mascota);
	}
	
	public void llenarLista() {
		
		Date fecha1 = new Date(2020,01,01,12,0,0);
		Date fecha2 = new Date(2023,05,12,12,0,0);
		Date fecha3 = new Date(2022,04,30,12,0,0);
		Date fecha4 = new Date(2021,07,15,12,0,0);
		Date fecha5 = new Date(2019,03,29,12,0,0);
		Date fecha6 = new Date(2018,02,04,12,0,0);
		
		petList.add(new Mascota(1, "Tobby", 1, "Es un perro", "Perro", "chihuahua.jpg", true, fecha1));
		petList.add(new Mascota(2, "Hercules", 3, "Es un perro", "Perro", "husky.jpeg", false, fecha2));
		petList.add(new Mascota(3, "Poncho", 2, "Es un perro", "Perro", "shiba-inu.jpg", true, fecha3));
		
		petList.add(new Mascota(4, "Willy", 2, "Es un gato", "Gato", "egipcio.jpg", false, fecha4));
		petList.add(new Mascota(5, "Sr Bigotes", 2, "Es un gato", "Gato", "heterocromia.jpg", true, fecha5));
		petList.add(new Mascota(6, "Manchas", 3, "Es un gato", "Gato", "siames.jpg", false, fecha6));
	}

}

