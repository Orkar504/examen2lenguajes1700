package unah.lenguajes1700.josemartinez.examen2.Models;

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
@Table(name="cuotas")
@Data
public class Cuotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigocuota")
    private Integer codigoCuota ;
    private Integer mes;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codigoprestamo", referencedColumnName = "codigoprestamo")

    private Prestamo prestamo;


    private Double interes; 
    private Double capital; 
    private Double saldo; 
 
}
