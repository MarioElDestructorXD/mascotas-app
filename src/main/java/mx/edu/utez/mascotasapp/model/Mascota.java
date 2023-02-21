package mx.edu.utez.mascotasapp.model;

public class Mascota {
	
	String nombre;
	Integer edad;
	String descripcion;
	String tipoMascota;
	String imagen;
	Boolean diponibleAdopcion;
	
	public Mascota(String nombre, Integer edad, String descripcion, String tipoMascota, String imagen,
			Boolean diponibleAdopcion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.tipoMascota = tipoMascota;
		this.imagen = imagen;
		this.diponibleAdopcion = diponibleAdopcion;
	}

	public Mascota() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
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

	public Boolean getDiponibleAdopcion() {
		return diponibleAdopcion;
	}

	public void setDiponibleAdopcion(Boolean diponibleAdopcion) {
		this.diponibleAdopcion = diponibleAdopcion;
	}
}
