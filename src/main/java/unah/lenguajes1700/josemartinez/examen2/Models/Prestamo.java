package unah.lenguajes1700.josemartinez.examen2.Models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="prestamos")
@Data
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoPrestamo;
    @Column(name="fechaapertura")
    private LocalDate fechaApertura;
    private double monto;
    private double cuota;
    private Integer plazo;
    private double interes;


    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="dni", referencedColumnName = "dni")
    private Cliente cliente;

}
