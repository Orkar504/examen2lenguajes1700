package unah.lenguajes1700.josemartinez.examen2.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes1700.josemartinez.examen2.Models.Cliente;
import unah.lenguajes1700.josemartinez.examen2.Models.Prestamo;
import unah.lenguajes1700.josemartinez.examen2.Repositorios.ClienteRepositorio;
import unah.lenguajes1700.josemartinez.examen2.Repositorios.PrestamoRepositorio;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Autowired
    private PrestamoServicio prestamoServicio;

    @Autowired 
    private CuotaServicio cuotaServicio;

     public Cliente crearCliente(Cliente nvoCliente){


        Prestamo nvoPrestamo =nvoCliente.getPrestamo();
        nvoPrestamo.setCuota( this.cuotaServicio.calcularCuota(nvoPrestamo.getMonto(),nvoPrestamo.getPlazo(), nvoPrestamo.getInteres()));
        nvoCliente.setPrestamo(nvoPrestamo);
        

        return this.clienteRepositorio.save(nvoCliente);
            
    }

    public boolean buscarPorIdentidad(String dni)
    {
        return this.clienteRepositorio.existsById(dni);
    }
    /*Plazo ser recibe en años  */
    

}
