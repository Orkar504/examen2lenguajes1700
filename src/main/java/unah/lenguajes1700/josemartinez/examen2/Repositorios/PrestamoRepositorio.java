package unah.lenguajes1700.josemartinez.examen2.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes1700.josemartinez.examen2.Models.Prestamo;

@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo,Integer>{

}
