package com.example.demo.modelos;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Anime extends Series implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Min(value = 0, message = "El numero tiene que ser 0 o mayor que 0")
	@Max(value = 120, message = "El numero tiene que ser 10 o menor que 10")
	private int puntuacion;
	
	@Min(value = 0, message = "El numero no puede ser menor que 0")
	private int episodios;
	
	private String estado;
	
	private String imagen;
	
	private String sinopsis;
	
	@ManyToMany(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	private List<User>usuarios;
	
	 public Anime() {
		super();
	}

	public Anime(Long id, String nombre, String genero, int puntuacion, int episodios,
			String estado, String imagen, String sinopsis) {
		super(nombre, genero);
		this.puntuacion = puntuacion;
		this.episodios = episodios;
		this.estado = estado;
		this.imagen = imagen;
		this.sinopsis = sinopsis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getpuntuacion() {
		return puntuacion;
	}

	public void setpuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getEpisodios() {
		return episodios;
	}

	public void setEpisodios(int episodios) {
		this.episodios = episodios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	
	
	
	
	
	
	
	
	
	

}
