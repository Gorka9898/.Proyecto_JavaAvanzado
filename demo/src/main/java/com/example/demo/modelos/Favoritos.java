package com.example.demo.modelos;

import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "favoritos")
public class Favoritos {
	
	@Id
	private long id;

	
	@CreationTimestamp
	private ZonedDateTime fecha_creacion;
	
	@UpdateTimestamp
	private ZonedDateTime fecha_actualizacion;

}
