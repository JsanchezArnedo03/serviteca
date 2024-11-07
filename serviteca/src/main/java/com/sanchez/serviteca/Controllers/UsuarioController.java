package com.sanchez.serviteca.Controllers;

import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/login")
    ResponseEntity<ResponseDTO> login(@RequestParam(value = "username") String username,
                                      @RequestParam(value = "password") String password) {
        ResponseDTO dto = usuarioService.login(username, password).getBody();
        return ResponseEntity.ok(dto);
    }
}
