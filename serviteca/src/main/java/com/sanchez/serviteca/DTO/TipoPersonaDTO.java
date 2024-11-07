package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.TipoPersona;
import lombok.Data;

import java.util.List;

@Data
public class TipoPersonaDTO {
    private Integer idTipoPersona;
    private String tipoPersona;

    public TipoPersonaDTO() {
    }

    public TipoPersonaDTO(TipoPersona persona) {
        this.idTipoPersona = persona.getIdTipoPersona();
        this.tipoPersona = persona.getTipoPersona();
    }

    public static TipoPersonaDTO toDto(TipoPersona persona){
        return new TipoPersonaDTO(persona);
    }
}
