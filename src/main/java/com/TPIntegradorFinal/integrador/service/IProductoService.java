package com.TPIntegradorFinal.integrador.service;

import com.TPIntegradorFinal.integrador.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductoService {

    //Importar lista de productos
    public List<Producto> getListaProducto();

    //Guardar producto
    public void saveProducto(Producto produ);

    //Traer un producto en particular
    public Producto findProducto(Long codigo_producto);

    //Eliminar un producto
    public void deleteProducto(Long codigo_producto);

    //Modificar un producto
    public void modifyProducto(Long codigo_productoOriginal,Long nuevoCodigo,
                                   String nuevoNombre,String nuevaMarca, Double nuevoCosto,
                                   Double nuevacantidadDisponible);

    //Falta Stock
    public List<Producto> getListaFaltaStock();
}
