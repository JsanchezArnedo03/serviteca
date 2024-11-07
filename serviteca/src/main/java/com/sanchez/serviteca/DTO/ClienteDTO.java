package com.sanchez.serviteca.DTO;

import lombok.Data;
import java.util.List;

@Data
public class ClienteDTO extends PersonaDTO {
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String telefono1;
    private String telefono2;
    private TipoPersonaDTO tipoPersona;
    private List<DetalleFacturaDTO> detalleFacturaList;
}
