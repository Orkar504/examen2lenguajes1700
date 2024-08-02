package unah.lenguajes1700.josemartinez.examen2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes1700.josemartinez.examen2.Servicios.ClienteServicio;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/creditos")

public class ClienteController {
    //@Autowired
    //private ClienteServicio clienteServicio;


    @GetMapping("/prueba")
    public String getMethodName() {
        return "Hola Examen";
    }
    
}
