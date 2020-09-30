package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "supervisor")
public class Supervisor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSupervisor;
	
	@Size(min = 3, max = 50, message = "Nombre debe tener minimo 3 caracteres")
	@Column(name = "nombre_supevisor", nullable = false, length = 50)
	private String nombreSupervisor;
	
	@Size(min = 3, max = 70, message = "Direccion debe tener minimo 3 caracteres")
	@Column(name = "direccion", nullable = false, length = 70)
	private String direccion;
	
	@Size(min = 11, max = 11, message = "Telefono debe tener minimo 11 caracteres")
	@Column(name = "telefono", nullable = false, length = 11)
	private String telefono;

	public Integer getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(Integer idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public String getNombreSupervisor() {
		return nombreSupervisor;
	}

	public void setNombreSupervisor(String nombreSupervisor) {
		this.nombreSupervisor = nombreSupervisor;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
