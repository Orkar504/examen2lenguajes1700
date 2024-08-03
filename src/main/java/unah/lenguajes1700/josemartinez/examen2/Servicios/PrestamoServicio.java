package unah.lenguajes1700.josemartinez.examen2.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes1700.josemartinez.examen2.Repositorios.PrestamoRepositorio;

@Service
public class PrestamoServicio {

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;


    

}
