package unah.lenguajes1700.josemartinez.examen2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes1700.josemartinez.examen2.Models.Cliente;
import unah.lenguajes1700.josemartinez.examen2.Servicios.ClienteServicio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/creditos/cliente")

public class ClienteController {

    @Autowired
    private ClienteServicio clienteServicio;

    @PostMapping("/crear/nuevo")
    public Cliente crearCliente(@RequestBody Cliente nvoCliente) {        
        if(!this.clienteServicio.buscarPorIdentidad(nvoCliente.getDni())){
            return this.clienteServicio.crearCliente(nvoCliente);
        }
        return null;
    }

    
}
