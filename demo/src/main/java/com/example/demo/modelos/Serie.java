package com.example.demo.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Serie extends Series{
	
	@Id
	@GeneratedValue
	private Long id;

}
