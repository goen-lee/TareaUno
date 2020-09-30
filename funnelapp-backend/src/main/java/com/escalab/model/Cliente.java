package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@Size(min = 3, max = 70, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "nombre_cliente", nullable = false, length = 70)
	private String nombreCliente;
	
	@Size(min = 3, max= 70, message = "Direccion debe tener minimo 3 caracteres")
	@Column(name = "direccion", nullable = false, length = 70)
	private String direccion;
	
	@Size(min = 11, max = 11, message = "Telefono debe tener minimo 11 caracteres")
	@Column(name = "telefono", nullable = false, length = 11)
	private String telefono;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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
