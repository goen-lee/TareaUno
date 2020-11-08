package com.escalab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escalab.model.CompraProducto;

public interface ICompraProductoRepo extends JpaRepository<CompraProducto, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO compra_producto(idProducto, idVenta VALUE (:idProducto, :idVenta)", nativeQuery = true)
	Integer Registrar(@Param("idProducto") Integer idProducto, @Param("idVenta") Integer idVenta);

	@Query("from CompraProducto cp where cp.producto.idProducto = :idProducto")
	List<CompraProducto> listarVentasPorProductos(@Param("idProducto") Integer idProducto);
}
