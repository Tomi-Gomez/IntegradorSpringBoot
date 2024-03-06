package com.TPIntegradorFinal.integrador.service;

import com.TPIntegradorFinal.integrador.dto.MayorVentaDTO;
import com.TPIntegradorFinal.integrador.model.Producto;
import com.TPIntegradorFinal.integrador.model.Venta;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IVentaService {

    //Lista completa de ventas
    public List<Venta> getListaVenta();

    //Crear Venta
    public void saveVenta(Venta venta);

    //Buscar venta
    public Venta findVenta(Long id);

    //Eliminar Venta
    public void deleteVenta(Long id);

    //Modificar Venta
    public void modifyVenta(Long idOriginal, Long nuevoCodigo, LocalDate nuevaFecha,Double nuevoTotal);

    //5. Obtener lista de productos, de una determinada venta
    public List<Producto> getListaVentaProdcutos(Long id);

    //6. Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
    public String cVentasMonto(LocalDate fecha_hoy);

    //7. Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el
    //apellido del cliente de la venta con el monto más alto de todas.
    public MayorVentaDTO mVenta();

}
