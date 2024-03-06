package com.TPIntegradorFinal.integrador.service;

import com.TPIntegradorFinal.integrador.dto.MayorVentaDTO;
import com.TPIntegradorFinal.integrador.model.Producto;
import com.TPIntegradorFinal.integrador.model.Venta;
import com.TPIntegradorFinal.integrador.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class VentaService implements IVentaService{

    @Autowired
    IVentaRepository IVentRepo;

    @Override
    public List<Venta> getListaVenta() {
        return IVentRepo.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {
        IVentRepo.save(venta);
    }

    @Override
    public Venta findVenta(Long id) {
        return IVentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteVenta(Long id) {
        IVentRepo.deleteById(id);
    }

    @Override
    public void modifyVenta(Long idOriginal, Long nuevoCodigo, LocalDate nuevaFecha, Double nuevoTotal) {
        Venta venta = this.findVenta(idOriginal);
        venta.setCodigo_venta(nuevoCodigo);
        venta.setFecha_venta(nuevaFecha);
        venta.setTotal(nuevoTotal);

        this.IVentRepo.save(venta);
    }

    @Override
    public List<Producto> getListaVentaProdcutos(Long id) {

        return  IVentRepo.findById(id).get().getListaProductos();
    }

    @Override
    public String cVentasMonto(LocalDate fecha_hoy) {
        List<Venta> ventas = IVentRepo.findAll();
        List<Venta> cantidadVentas = new ArrayList<>();

        double total= 0;
        String mensaje= "No funca el if";

        for (Venta v:ventas){
            if(v.getFecha_venta().equals(fecha_hoy)){
                total = total + v.getTotal();
                cantidadVentas.add(v);
                mensaje = "El monto total que se registro en esta fecha es: $" + total + ", y la cantidad de ventas registradas" +
                        "es de " + cantidadVentas.size();
            }else {
                mensaje=  "En el dia de la fecha no se encuentra ninguna fecha registrada" + fecha_hoy;
            }
        }

        return mensaje;
    }

    @Override
    public MayorVentaDTO mVenta() {
        double total = 0;
        List<Venta> ventas = IVentRepo.findAll();

        MayorVentaDTO mVentaDto = new MayorVentaDTO();
        for (Venta venta : ventas){
            if(venta.getTotal() > total){
               total = venta.getTotal();
               mVentaDto.setCodigo_venta(venta.getCodigo_venta());
               mVentaDto.setTotal(venta.getTotal());
               mVentaDto.setCantidadProductos(venta.getListaProductos().size());
               mVentaDto.setNombre(venta.getUnCliente().getNombre());
               mVentaDto.setApellido(venta.getUnCliente().getApellido());
            }
        }
        return mVentaDto;
    }
}
