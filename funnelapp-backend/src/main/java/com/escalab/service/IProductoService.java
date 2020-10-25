package com.escalab.service;

import java.util.List;

import com.escalab.dto.ConsultaListaVentaDTO;
import com.escalab.dto.ConsultaResumenDTO;
import com.escalab.dto.FiltroConsultaDTO;
import com.escalab.model.Producto;

public interface IProductoService extends ICRUD<Producto>{
	
	//registrarTransaccional(ConsultaListaVentaDTO dto); 
	
	List<Producto> buscar(FiltroConsultaDTO filtro);
	
	List<Producto> buscarPorIdProducto(FiltroConsultaDTO filtro);
	
	List<ConsultaResumenDTO> listarResumen();
	
	byte[] generarReporte();
}
