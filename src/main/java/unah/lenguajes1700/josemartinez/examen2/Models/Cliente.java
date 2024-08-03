package unah.lenguajes1700.josemartinez.examen2.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cliente")
@Data
public class Cliente {

    @Id
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;

@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
private Prestamo prestamo;

}
