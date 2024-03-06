package com.TPIntegradorFinal.integrador.service;

import com.TPIntegradorFinal.integrador.controlador.ProductoController;
import com.TPIntegradorFinal.integrador.model.Producto;
import com.TPIntegradorFinal.integrador.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoService implements IProductoService{

    @Autowired
    IProductoRepository IProduRepo;

    @Override
    public List<Producto> getListaProducto() {
        return IProduRepo.findAll();
    }

    @Override
    public void saveProducto(Producto produ) {
        IProduRepo.save(produ);
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return IProduRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        IProduRepo.deleteById(codigo_producto);
    }

    @Override
    public void modifyProducto(Long codigo_productoOriginal, Long nuevoCodigo, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double nuevacantidadDisponible) {
        Producto produ = this.findProducto(codigo_productoOriginal);
        produ.setCodigo_producto(nuevoCodigo);
        produ.setNombre(nuevoNombre);
        produ.setMarca(nuevaMarca);
        produ.setCosto(nuevoCosto);
        produ.setCantidad_disponible(nuevacantidadDisponible);

        this.IProduRepo.save(produ);

    }

    @Override
    public List<Producto> getListaFaltaStock() {
        double stock = 5;
        List<Producto> StockFaltante=new ArrayList<>();
        List<Producto> listaProducto = IProduRepo.findAll();

        for (Producto lp: listaProducto) {
            if(lp.getCantidad_disponible() < stock){
                StockFaltante.add(lp);
            }
        }

        return StockFaltante;
    }
}
