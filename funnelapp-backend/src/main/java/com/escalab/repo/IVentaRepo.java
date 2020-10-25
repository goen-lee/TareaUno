package com.escalab.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escalab.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer> {

	@Query("from Venta v where c.fechaVenta between :fechaVenta and :fechaSgte")
	List<Venta> buscarFecha(@Param("fechaVenta") LocalDateTime fechaVenta, @Param("fechaSgte") LocalDateTime fechaSgte);
}
