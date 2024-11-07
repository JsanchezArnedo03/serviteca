package com.sanchez.serviteca.Repositories;

import com.sanchez.serviteca.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    @Query("SELECT p FROM Persona p " +
            "WHERE UPPER(p.tipoPersona.tipoPersona) = UPPER('cliente')")
    List<Persona> getALlClient();

    @Query("SELECT p FROM Persona p JOIN p.tipoPersona " +
            "tp WHERE UPPER(tp.tipoPersona) = UPPER('empleado')")
    List<Persona> getALlEmployees();

    @Query("SELECT p FROM Persona p " +
            "WHERE p.numeroDocumento = :documento")
    Persona findByDocumento(String documento);

    @Query("SELECT p FROM Persona p " +
            "INNER JOIN p.tipoPersona tp " +
            "WHERE UPPER(tp.tipoPersona) = UPPER(:filtro) " +
            "AND p.id = :id")
    Persona empladoDisable(Integer id,String filtro);

    @Query("SELECT p FROM Persona p JOIN p.tipoPersona " +
            "tp WHERE UPPER(tp.tipoPersona) = UPPER('empleado')")
    Persona findEmpleado();

    @Query("SELECT p FROM Persona p " +
            "WHERE UPPER(p.tipoPersona.tipoPersona) = UPPER('cliente') " +
            "AND p.id = :id")
    Optional<Persona> findCliente(Integer id);
}
