package com.example.demo.modelos;


import jakarta.persistence.Embeddable;


@Embeddable
public class Direccion {
	

	 
	private String calle;
	private String municipio;
	private String portal;
	
	
	public Direccion(String calle, String municipio, String portal) {
		super();
		this.calle = calle;
		this.municipio = municipio;
		this.portal = portal;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getPortal() {
		return portal;
	}


	public void setPortal(String portal) {
		this.portal = portal;
	}
	
	
	
	
	


	
	 

}
