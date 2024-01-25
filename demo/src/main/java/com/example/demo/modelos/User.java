package com.example.demo.modelos;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Size(min = 3, max = 50)
	private String name;
	 
	@NotBlank
	@Email(message = "Please enter a valid e-mail address")
	private String email;
	 
	@NotBlank
	@Size(min = 8, max = 15)
	private String password;
	
	private Direccion direccion;
	
	@ManyToMany(mappedBy ="usuarios", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Anime>favoritos;

	public User(Long id, @Size(min = 3, max = 50) String name,
			@NotBlank @Email(message = "Please enter a valid e-mail address") String email,
			@NotBlank @Size(min = 8, max = 15) String password, Direccion direccion) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.direccion= direccion;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
	
	
	 

}
