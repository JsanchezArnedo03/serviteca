package com.sanchez.serviteca.Repositories;

import com.sanchez.serviteca.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query("SELECT c FROM Categoria c " +
            "WHERE UPPER(c.nombreCategoria) = UPPER(:filtro)")
    Categoria findByName(String filtro);
}
