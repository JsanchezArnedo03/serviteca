package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.Persona;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
public class PersonaDTO {

    private Integer id;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String telefono1;
    private String telefono2;
    private Date fechaIngreso;
    private Date fechaInactivacion;
    private CargoDTO cargo;
    private TipoDocumentoDTO tipoDocumento;
    private TipoPersonaDTO tipoPersona;

    public PersonaDTO() {
    }

    public PersonaDTO(Persona persona) {
        this.id = persona.getId();
        this.numeroDocumento = persona.getNumeroDocumento();
        this.primerNombre = persona.getPrimerNombre();
        this.segundoNombre = persona.getSegundoNombre();
        this.primerApellido = persona.getPrimerApellido();
        this.segundoApellido = persona.getSegundoApellido();
        this.email = persona.getEmail();
        this.telefono1 = persona.getTelefono1();
        this.telefono2 = persona.getTelefono2();
        this.fechaIngreso = persona.getFechaIngreso();
        this.fechaInactivacion = persona.getFechaInactivacion();
        this.tipoDocumento = Optional.ofNullable(persona.getTipoDocumento())
                .map(TipoDocumentoDTO::toDto)
                .orElse(new TipoDocumentoDTO());
        this.tipoPersona = Optional.ofNullable(persona.getTipoPersona())
                .map(TipoPersonaDTO::toDto)
                .orElse(new TipoPersonaDTO());
        this.cargo = Optional.ofNullable(persona.getCargo())
                .map(CargoDTO::toDto)
                .orElse(new CargoDTO());
    }

    public static PersonaDTO toDto(Persona persona) {
        return new PersonaDTO(persona);
    }
}
