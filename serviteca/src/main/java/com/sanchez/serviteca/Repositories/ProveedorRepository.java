package com.sanchez.serviteca.Repositories;

import com.sanchez.serviteca.Entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    @Query("SELECT p FROM Proveedor p " +
            "WHERE UPPER(p.nombreProveedor) = UPPER(:nombre)")
    Proveedor findByName(String nombre);
}
