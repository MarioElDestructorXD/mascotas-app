package utez.edu.mx.mascotas.app.model;

import java.util.Date;

public class Mascota {
	
	private int id;
	private String nombre;
	private int edad;
	private String descripcion, tipoMascota, imagen;
	private boolean disponibleAdopcion;
	private Date fechaRescate;
	private Caracter caracter;
	
	
	public Mascota() {}

	public Mascota(String nombre, int edad, String descripcion, String tipoMascota, String imagen,
			boolean disponibleAdopcion) {
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.tipoMascota = tipoMascota;
		this.imagen = imagen;
		this.disponibleAdopcion = disponibleAdopcion;
	}

	public Mascota(int id, String nombre, int edad, String descripcion, String tipoMascota, String imagen,
			boolean disponibleAdopcion) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.tipoMascota = tipoMascota;
		this.imagen = imagen;
		this.disponibleAdopcion = disponibleAdopcion;
	}
	
	

	public Mascota(int id, String nombre, int edad, String descripcion, String tipoMascota, String imagen,
			boolean disponibleAdopcion, Date fechaRescate) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.tipoMascota = tipoMascota;
		this.imagen = imagen;
		this.disponibleAdopcion = disponibleAdopcion;
		this.fechaRescate = fechaRescate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isDisponibleAdopcion() {
		return disponibleAdopcion;
	}

	public void setDisponibleAdopcion(boolean disponibleAdopcion) {
		this.disponibleAdopcion = disponibleAdopcion;
	}

	public Date getFechaRescate() {
		return fechaRescate;
	}

	public void setFechaRescate(Date fechaRescate) {
		this.fechaRescate = fechaRescate;
	}
	
	public Caracter getCaracter() {
		return caracter;
	}

	public void setCaracter(Caracter caracter) {
		this.caracter = caracter;
	}
}
