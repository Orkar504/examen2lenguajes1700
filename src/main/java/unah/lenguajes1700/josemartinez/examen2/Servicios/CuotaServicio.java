package unah.lenguajes1700.josemartinez.examen2.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes1700.josemartinez.examen2.Models.Prestamo;
import unah.lenguajes1700.josemartinez.examen2.Repositorios.CuotaRepositorio;

@Service
public class CuotaServicio {

    @Autowired
    private CuotaRepositorio cuotaRepositorio;


    public String generarTablaCuotas(Prestamo nvPrestamo)
    {


        return "Se han generado las cuotas";
    }

    public double calcularCuota(double monto, Integer plazo, double intereses)
    {
         double interest = intereses/12;
         Integer meses = plazo*12;
         double cuota;
         double denominador;
         double numerador;

         numerador = monto*interest*Math.pow((1+interest), meses);
         denominador = (1+Math.pow((1 + interest), meses)) - 1;

         cuota = (numerador)/(denominador);

         return cuota; 
    }

}
