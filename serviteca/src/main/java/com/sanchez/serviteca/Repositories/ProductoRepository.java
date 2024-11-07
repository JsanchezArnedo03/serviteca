package com.sanchez.serviteca.Repositories;

import com.sanchez.serviteca.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
