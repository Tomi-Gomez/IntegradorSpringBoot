package com.TPIntegradorFinal.integrador.controlador;

import com.TPIntegradorFinal.integrador.dto.MayorVentaDTO;
import com.TPIntegradorFinal.integrador.model.Producto;
import com.TPIntegradorFinal.integrador.model.Venta;
import com.TPIntegradorFinal.integrador.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    IVentaService IVentSer;

    @GetMapping("/ventas")
    public List<Venta> getListaVenta(){
        return IVentSer.getListaVenta();
    }

    @PostMapping("/ventas/crear")
    public String saveVenta (@RequestBody Venta venta){
        IVentSer.saveVenta(venta);
        return "La venta fue creada correctamente";
    }

    @GetMapping("/ventas/{codigo_Venta}")
    public Venta findVenta(@PathVariable Long codigo_Venta){
        return IVentSer.findVenta(codigo_Venta);
    }

    @DeleteMapping("/ventas/eliminar/{codigo_Venta}")
    public String deleteVenta(@PathVariable Long codigo_Venta){
        IVentSer.deleteVenta(codigo_Venta);
        return "La venta se ha eliminado correctamente";
    }

    @PutMapping("/ventas/editar/{codigo_Venta}")
    public Venta modifyVenta (@PathVariable Long codigo_Venta,
                              @RequestParam (required = false,name = "nuevoCodigo") Long nuevoCodigo,
                              @RequestParam (required = false,name = "NuevaFecha")LocalDate nuevaFecha,
                              @RequestParam (required = false,name = "NuevoTotal") Double nuevoTotal){

        IVentSer.modifyVenta(codigo_Venta,nuevoCodigo,nuevaFecha,nuevoTotal);

        return this.IVentSer.findVenta(codigo_Venta);
    }

    //5. Obtener la lista de productos de una determinada venta
    @GetMapping("/ventas/productos/{codigo_Venta}")
    public List<Producto> getListaProducto(@PathVariable Long codigo_Venta){
        return IVentSer.getListaVentaProdcutos(codigo_Venta);
    }

    //6. Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
    @GetMapping("/ventas/fechaHoy")
    public String getMontoVenta(@RequestParam LocalDate fecha_venta){
        return IVentSer.cVentasMonto(fecha_venta);
    }

    //7. Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el apellido del cliente de la venta con el monto más alto de todas.
    @GetMapping("/ventas/mayorVenta")
    public MayorVentaDTO getMayorVenta(){
        return IVentSer.mVenta();
    }
}
