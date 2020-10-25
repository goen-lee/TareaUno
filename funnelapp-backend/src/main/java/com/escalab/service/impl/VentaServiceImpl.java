package com.escalab.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.dto.FiltroConsultaDTO;
import com.escalab.model.Venta;
import com.escalab.repo.IVentaRepo;
import com.escalab.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepo repo;
	
	@Override
	public Venta registrar(Venta obj) {
		return repo.save(obj);
	}
	
	@Override
	public Venta modificar(Venta obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Venta> listar(){
		return repo.findAll();
	} 
	
	@Override
	public Venta leerPorId(Integer id) {
		Optional<Venta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Venta();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	public List<Venta> buscarFecha(FiltroConsultaDTO filtro){
		LocalDateTime fechaSgte = filtro.getFechaVenta().plusDays(1);
		return repo.buscarFecha(filtro.getFechaVenta(), fechaSgte);
	}
	
	/*public List<Venta> buscarComision(FiltroConsultaDTO filtro){
		return repo
	}*/
}


