package unah.lenguajes1700.josemartinez.examen2.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes1700.josemartinez.examen2.Models.Cuotas;
import unah.lenguajes1700.josemartinez.examen2.Models.Prestamo;
import unah.lenguajes1700.josemartinez.examen2.Repositorios.CuotaRepositorio;

@Service
public class CuotaServicio {

    @Autowired
    private CuotaRepositorio cuotaRepositorio;


    public String generarTablaCuotas(Prestamo nvoPrestamo)
    {

        Cuotas nCuotas = new Cuotas();
        nCuotas.setPrestamo(nvoPrestamo);
        Integer meses = nvoPrestamo.getPlazo()*12;
        double interest = nvoPrestamo.getInteres()/12;
        double saldoMensual = 0;
        double interesMensual = 0;
        double capitalMensual = 0;

        for (Integer i = 0 ; i<meses; i++)
        { 
            if(i == 0 )
            {
                nCuotas.setMes(0);
                nCuotas.setInteres(null);
                nCuotas.setCapital(null);
                nCuotas.setSaldo(nvoPrestamo.getMonto());
                nCuotas.setPrestamo(nvoPrestamo);
            } else{
                nCuotas.setMes(i);
                nCuotas.setInteres(saldoMensual*interest);
                interesMensual =nCuotas.getInteres();
                nCuotas.setCapital(nvoPrestamo.getCuota()-interesMensual);
                saldoMensual = saldoMensual - capitalMensual; 
                nCuotas.setSaldo(saldoMensual);

            }
            saldoMensual = nCuotas.getSaldo();

            this.cuotaRepositorio.save(nCuotas);

        }

        return "se ha generado la tabla";
    }

    public double calcularCuota(double monto, Integer plazo, double intereses)
    {
         double interest = intereses/12;
         Integer meses = plazo*12;
         double cuota;
         double denominador;
         double numerador;

         numerador = monto*interest*Math.pow((1+interest), meses);
         denominador = Math.pow((1 + interest), meses) - 1;

         cuota = (numerador)/(denominador);

         return cuota; 
    }

}
