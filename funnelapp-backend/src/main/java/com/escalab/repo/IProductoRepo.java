package com.escalab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escalab.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {
	
	@Query("from Producto p where LOWER(p.nombreProducto) like %:nombreProducto% or LOWER(p.marca.descripcion) like %:marca%")
	List<Producto> buscar(@Param("nombreProducto") String nombreProducto,  @Param("marca") String marca);

	// >= < 
	@Query("from Producto p where p.idProducto=:idProducto")
	List<Producto> buscarIdProducto(@Param("idProducto") Integer idProducto);
	
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();
}
