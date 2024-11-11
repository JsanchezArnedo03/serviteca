package com.sanchez.serviteca.Repositories;

import com.sanchez.serviteca.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Query("SELECT r FROM Reserva r INNER JOIN r.cliente c WHERE c.numeroDocumento = :filtro")
    Reserva findReservaByFiltro(String filtro);
}
