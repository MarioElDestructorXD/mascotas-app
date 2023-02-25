package mx.edu.utez.mascotasapp.model;

public class Publicacion {
	
	private String titulo;
	private String contenido;
	private Boolean estatus;
	
	public Publicacion(String titulo, String contenido, Boolean estatus) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.estatus = estatus;
	}

	public Publicacion() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	
}
