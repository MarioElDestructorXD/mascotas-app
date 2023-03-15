package utez.edu.mx.mascotas.app.model;

public class Caracter {
	
	public Integer id;
	public String nombre;
	public Caracter(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Caracter() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
