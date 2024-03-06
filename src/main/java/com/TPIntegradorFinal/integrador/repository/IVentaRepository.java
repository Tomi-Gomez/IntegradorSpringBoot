package com.TPIntegradorFinal.integrador.repository;

import com.TPIntegradorFinal.integrador.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {
}
