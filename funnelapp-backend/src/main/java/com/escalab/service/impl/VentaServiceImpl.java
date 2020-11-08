package com.escalab.service.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.escalab.dto.ConsultaResumenDTO;
import com.escalab.dto.FiltroConsultaDTO;
import com.escalab.dto.VentaListaProductoDTO;
import com.escalab.model.Venta;
import com.escalab.repo.ICompraProductoRepo;
import com.escalab.repo.IVentaRepo;
import com.escalab.service.ICompraProductoService;
import com.escalab.service.IVentaService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepo repo;
	
	@Autowired
	private ICompraProductoRepo cpRepo;
	
	@Override
	public Venta registrar(Venta obj) {
		return repo.save(obj);
	}
	
	@Transactional
	@Override
	public Venta registrarTransaccional(VentaListaProductoDTO dto) {
		repo.save(dto.getVenta());
		dto.getLstProducto().forEach(pr -> cpRepo.Registrar(dto.getVenta().getIdVenta(), pr.getIdProducto()));
		return dto.getVenta();
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
	
	@Override
	public List<Venta> buscar(FiltroConsultaDTO filtro){
		return repo.buscar(filtro.getNombreCliente(),filtro.getNombreVendedor());
	}
	
	@Override
	public List<Venta> buscarFecha(FiltroConsultaDTO filtro){
		LocalDateTime fechaSgte = filtro.getFechaVenta().plusDays(1);
		return repo.buscarFecha(filtro.getFechaVenta(), fechaSgte);
	}
	
	@Override
	public  List<ConsultaResumenDTO> listarResumen(){
		List<ConsultaResumenDTO> ventas = new ArrayList<>();
		
		repo.listarResumen().forEach(x ->{
			ConsultaResumenDTO cr = new ConsultaResumenDTO();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[0]));
			ventas.add(cr);
		});
		return ventas;
	} 
	
	@Override
	public byte[] generarReporte() {
		byte[] data = null;
		
		try {
			File file = new ClassPathResource("/reports/ventas.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;	
	}	
}


