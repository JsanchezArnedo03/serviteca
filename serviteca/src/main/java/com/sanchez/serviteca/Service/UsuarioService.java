package com.sanchez.serviteca.Service;

import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.DTO.UsuarioDTO;
import com.sanchez.serviteca.Entities.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {
    ResponseEntity<ResponseDTO> login(String username, String psw);

    ResponseEntity<ResponseDTO> createUser(UsuarioDTO usuarioDTO);
}
