package com.escalab.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.escalab.dto.ConsultaListaVentaDTO;
import com.escalab.dto.ConsultaResumenDTO;
import com.escalab.dto.FiltroConsultaDTO;
import com.escalab.model.Producto;
import com.escalab.repo.ICompraProductoRepo;
import com.escalab.repo.IProductoRepo;
import com.escalab.service.IProductoService;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo repo;
	
	@Autowired
	private ICompraProductoRepo cpRepo;
	
	@Override
	public Producto registrar(Producto obj) {
		return repo.save(obj);
	}
	
	/*@Transactional
	@Override
	public Producto registrarTransaccional(ConsultaListaVentaDTO dto) {
		repo.save(dto.getProducto());
		dto.getLstVenta().forEach(ex -> cpRepo.Registrar(dto.getProducto().getIdProducto(), ex.getIdVenta()));
		return dto.getProducto();
	}*/// ta malo hay que hacer El de ventas hacias Productos.
	
	
	
	@Override
	public Producto modificar(Producto obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Producto> listar(){
		return repo.findAll();
	}
	
	@Override
	public Producto leerPorId(Integer id) {
		Optional<Producto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Producto();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public List<Producto> buscar(FiltroConsultaDTO filtro){
		return repo.buscar(filtro.getNombreProducto(), filtro.getMarca());
	}
	
	@Override
	public List<Producto> buscarPorIdProducto(FiltroConsultaDTO filtro){
		return repo.buscarIdProducto(filtro.getIdProducto());
	}
	
	@Override
	public List<ConsultaResumenDTO> listarResumen() {
		List<ConsultaResumenDTO> productos = new ArrayList<ConsultaResumenDTO>();
		
		repo.listarResumen().forEach(x -> {
			ConsultaResumenDTO cr = new ConsultaResumenDTO();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setNombreProducto(String.valueOf(x[1]));
			productos.add(cr);
		});
		return productos;
	}
	
	public byte[] generarReporte() {
		byte[] data = null;
		
		try {
			 	File file = new ClassPathResource("/reports/productos.jasper").getFile();
			 	JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
