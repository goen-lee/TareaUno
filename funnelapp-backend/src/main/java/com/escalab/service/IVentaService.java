package com.escalab.service;

import java.util.List;

import com.escalab.dto.ConsultaResumenDTO;
import com.escalab.dto.FiltroConsultaDTO;
import com.escalab.dto.VentaListaProductoDTO;
import com.escalab.model.Venta;

public interface IVentaService extends ICRUD<Venta>{
	
	Venta registrarTransaccional(VentaListaProductoDTO dto);
	
	List<Venta> buscar(FiltroConsultaDTO filtro);
	
	List<Venta> buscarFecha(FiltroConsultaDTO filtro);
	
	List<ConsultaResumenDTO> listarResumen();
	
	byte[] generarReporte();

}
