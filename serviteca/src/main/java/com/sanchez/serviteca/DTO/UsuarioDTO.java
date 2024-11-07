package com.sanchez.serviteca.DTO;

import com.sanchez.serviteca.Entities.Usuario;
import lombok.Data;

import java.util.Optional;

@Data
public class UsuarioDTO {
    private Integer id;
    private String username;
    private String psw;
    private PersonaDTO persona;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.username = usuario.getUsername();
        this.psw = usuario.getPsw();
        this.persona = Optional.ofNullable(usuario.getPersona())
                .map(PersonaDTO::toDto).orElse(new PersonaDTO());
    }

    public static UsuarioDTO toDto(Usuario usuario) {
        return new UsuarioDTO(usuario);
    }
}
