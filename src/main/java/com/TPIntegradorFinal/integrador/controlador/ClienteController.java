package com.TPIntegradorFinal.integrador.controlador;

import com.TPIntegradorFinal.integrador.model.Cliente;
import com.TPIntegradorFinal.integrador.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    IClienteService ICliSer;

    @GetMapping("/clientes")
    public List<Cliente> getListaClientes(){
        return ICliSer.getListaClientes();
    }

    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cli){
        ICliSer.saveCliente(cli);
        return "El cliente ha sido creado correctamente";
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return ICliSer.findCliente(id_cliente);
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        ICliSer.deleteCliente(id_cliente);
        return "El cliente ha sido eliminado correctamente";
    }

    @PutMapping("/clientes/modificar/{id_original}")
    public Cliente modifyCliente(@PathVariable Long id_original,
                                 @RequestParam (required = false,name = "idnuevo")Long idNuevo,
                                 @RequestParam (required = false,name ="nuevoNombre")String nuevoNombre,
                                 @RequestParam (required = false,name = "nuevoApellido")String nuevoApellido,
                                 @RequestParam (required = false, name = "nuevoDni")String nuevoDni){

        ICliSer.modifyCliente(id_original,idNuevo,nuevoNombre,nuevoApellido,nuevoDni);

        return this.ICliSer.findCliente(id_original); //En el caso que de error, chequar si me cambio el ID , en la BD.
    }
}
