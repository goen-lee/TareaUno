package com.escalab.dto;

import java.time.LocalDateTime;

public class FiltroConsultaDTO {

	private String nombreProducto;
	private String marca;
	private Integer IdProducto;
	private LocalDateTime fechaVenta;
	private String NombreCliente;
	private String NombreVendedor;
	
	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getIdProducto() {
		return IdProducto;
	}
	public void setIdProducto(Integer idProducto) {
		IdProducto = idProducto;
	}
	public String getNombreCliente() {
		return NombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}
	public String getNombreVendedor() {
		return NombreVendedor;
	}
	public void setNombreVendedor(String nombreVendedor) {
		NombreVendedor = nombreVendedor;
	}
}
