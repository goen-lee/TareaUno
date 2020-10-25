package com.escalab.dto;

import java.util.List;

import com.escalab.model.Producto;
import com.escalab.model.Venta;

public class ConsultaListaVentaDTO {
	
	private Producto producto;
	private List<Venta> lstVenta;
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public List<Venta> getLstVenta() {
		return lstVenta;
	}
	public void setLstVenta(List<Venta> lstVenta) {
		this.lstVenta = lstVenta;
	}

}
