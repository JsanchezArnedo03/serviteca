package com.sanchez.serviteca.Service.impl;

import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Entities.Usuario;
import com.sanchez.serviteca.Repositories.UsuarioRepository;
import com.sanchez.serviteca.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<ResponseDTO> login(String username, String psw) {
        if (username.isEmpty() && psw.isEmpty()) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder()
                    .error(true)
                    .mensaje("Username and password cannot be empty")
                    .build());
        }
        Optional<Usuario> isAuthenticated = Optional.ofNullable(usuarioRepository.login(username, psw));
        if (isAuthenticated.isPresent()) {
            return ResponseEntity.ok(ResponseDTO.builder()
                    .error(false)
                    .mensaje("Bienvenido")
                    .build());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseDTO.builder()
                    .error(true)
                    .mensaje("Invalid credentials")
                    .build());
        }
    }
}
