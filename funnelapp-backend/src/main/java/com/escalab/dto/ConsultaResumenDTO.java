package com.escalab.dto;

public class ConsultaResumenDTO {
	
	private Integer cantidad;
	private String  nombreProducto;
	
	public ConsultaResumenDTO() {
		
	}

	public ConsultaResumenDTO(Integer cantidad, String nombreProducto) {
		super();
		this.cantidad = cantidad;
		this.nombreProducto = nombreProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
}
