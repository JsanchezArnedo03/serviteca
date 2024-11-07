package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.Proveedor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Data
public class ProveedorDTO implements Serializable {

    private Integer idProveedor;
    private String codigoContable;
    private String direccion;
    private String email;
    private String nombreProveedor;
    private String razonSocial;
    private String telefono;
    private boolean estado;
    private TipoDocumentoDTO tipoDocumento;

    public ProveedorDTO() {
    }

    public ProveedorDTO(Proveedor proveedor) {
        this.idProveedor = proveedor.getIdProveedor();
        this.codigoContable = proveedor.getCodigoContable();
        this.direccion = proveedor.getDireccion();
        this.email = proveedor.getEmail();
        this.nombreProveedor = proveedor.getNombreProveedor();
        this.razonSocial = proveedor.getRazonSocial();
        this.telefono = proveedor.getTelefono();
        this.estado = proveedor.getEstado();
        this.tipoDocumento = Optional.ofNullable(proveedor.getTipoDocumento())
                .map(TipoDocumentoDTO::toDto)
                .orElse(new TipoDocumentoDTO());
    }

    public static ProveedorDTO toDto(Proveedor proveedor) {
        return new ProveedorDTO(proveedor);
    }
}
