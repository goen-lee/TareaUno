package com.escalab.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escalab.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer> {

	@Query("from Venta v where LOWER(v.cliente.nombreCliente) like %:nombreCliente% or LOWER(v.vendedor.nombreVendedor) like %:nombreVendedor%")
	List<Venta> buscar(@Param("nombreCliente")String nombrecliente, @Param("nombreVendedor")String nombreVendedor);
	
	@Query("from Venta v where v.fecha_venta between :fechaVenta and :fechaSgte")
	List<Venta> buscarFecha(@Param("fechaVenta") LocalDateTime fechaVenta, @Param("fechaSgte") LocalDateTime fechaSgte);
	
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();
	
}
