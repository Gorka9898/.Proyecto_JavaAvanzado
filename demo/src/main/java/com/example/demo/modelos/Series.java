package com.example.demo.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
public class Series {
	
	@Id
	@GeneratedValue(generator= "ID_GENERATOR")
	private Long id;
	
	@NotBlank
	private String nombre;
	 
	@NotBlank
	private String genero;
	 


	public Series() {
		super();
	}
	
	public Series(String nombre, @NotBlank String genero) {
		super();
		this.nombre = nombre;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	
	
	
	
	 

}

