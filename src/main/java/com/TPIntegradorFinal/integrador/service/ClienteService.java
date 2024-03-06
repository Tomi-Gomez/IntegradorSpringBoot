package com.TPIntegradorFinal.integrador.service;

import com.TPIntegradorFinal.integrador.model.Cliente;
import com.TPIntegradorFinal.integrador.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    IClienteRepository ICliRepo;

    @Override
    public List<Cliente> getListaClientes() {
        return ICliRepo.findAll();
    }

    @Override
    public void saveCliente(Cliente cli) {
        ICliRepo.save(cli);
    }

    @Override
    public Cliente findCliente(Long id) {
        return ICliRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCliente(Long id) {
        ICliRepo.deleteById(id);
    }

    @Override
    public void modifyCliente(Long id_original, Long idNuevo, String nuevoNombre, String nuevoApellido, String nuevoDni) {
        Cliente cli = this.findCliente(id_original);
        cli.setId_cliente(idNuevo);
        cli.setNombre(nuevoNombre);
        cli.setApellido(nuevoApellido);
        cli.setDni(nuevoDni);

        this.ICliRepo.save(cli);


    }
}
