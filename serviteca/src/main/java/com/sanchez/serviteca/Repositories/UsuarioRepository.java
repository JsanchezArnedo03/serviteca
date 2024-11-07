package com.sanchez.serviteca.Repositories;

import com.sanchez.serviteca.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u " +
            "WHERE u.username = :username " +
            "AND u.psw =:password ")
    Usuario login(String username, String password);
}
