package com.TPIntegradorFinal.integrador.controlador;

import com.TPIntegradorFinal.integrador.model.Producto;
import com.TPIntegradorFinal.integrador.service.IProductoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    IProductoService IProduServ;

    @GetMapping("/productos")
    public List<Producto> getListaProduct(){
        return IProduServ.getListaProducto();
    }

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto produ){
        IProduServ.saveProducto(produ);
        return "El producto fue creado correctamente";
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return IProduServ.findProducto(codigo_producto);
    }

    @DeleteMapping("/producto/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        IProduServ.deleteProducto(codigo_producto);
        return "El producto fue eliminado correctamente";
    }

    @PutMapping("/producto/editar/{codigo_producto}")
    public Producto modifyProducto(@PathVariable Long codigo_producto,
                                   @RequestParam (required = false,name="nuevoCodigo")Long nuevoCodigo,
                                   @RequestParam (required = false,name="nuevoNombre")String nuevoNombre,
                                   @RequestParam (required = false,name="nuevaMarca")String nuevaMarca,
                                   @RequestParam (required = false,name="nuevoCosto")Double nuevoCosto,
                                   @RequestParam (required = false,name = "nuevaCantidadDisponible") Double nuevacantidadDisponible){

        IProduServ.modifyProducto(codigo_producto,nuevoCodigo,nuevoNombre,nuevaMarca,nuevoCosto,nuevacantidadDisponible);

        Producto produ = this.findProducto(codigo_producto);

        return produ;

    }

    // 4 - Obtener todos los productos cuya cantidad_disponible sea menor a 5
    @GetMapping("/producto/falta_stock")
    public List<Producto> getStockFaltante(){
        return IProduServ.getListaFaltaStock();
    }


}
