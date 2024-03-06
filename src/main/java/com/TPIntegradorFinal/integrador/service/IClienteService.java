package com.TPIntegradorFinal.integrador.service;

import com.TPIntegradorFinal.integrador.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {

    //Lista de clientes
    public List<Cliente> getListaClientes();

    //Crear/guardar cliente
    public void saveCliente(Cliente cli);

    //Buscar cliente
    public Cliente findCliente(Long id);

    //Eliminar cliente
    public void deleteCliente(Long id);

    //Editar cliente
    public void modifyCliente(Long id_original,Long idNuevo,String nuevoNombre,
                                 String nuevoApellido,String nuevoDni);
}
