package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.TipoDocumento;
import lombok.Data;

import java.util.List;

@Data
public class TipoDocumentoDTO {

    private Integer idTipoDocumento;
    private String descripcion;
    private String siglas;
    private String tipoDocumento;

    public TipoDocumentoDTO() {
    }

    public TipoDocumentoDTO(TipoDocumento tipoDocumento) {
        this.idTipoDocumento = tipoDocumento.getIdTipoDocumento();
        this.descripcion = tipoDocumento.getDescripcion();
        this.siglas = tipoDocumento.getSiglas();
        this.tipoDocumento = tipoDocumento.getTipoDocumento();
    }

    public static TipoDocumentoDTO toDto(TipoDocumento tipoDocumento) {
        return new TipoDocumentoDTO(tipoDocumento);
    }
}
