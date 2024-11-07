package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.DetalleFactura;
import lombok.Data;

import java.util.Optional;

@Data
public class DetalleFacturaDTO {

    private Integer idDetalle;
    private PersonaDTO idEmpleado;
    private ProductoDTO idProducto;
    private ReservaDTO idReserva;

    public DetalleFacturaDTO() {
    }

    public DetalleFacturaDTO(DetalleFactura detalleFactura) {
        this.idDetalle = detalleFactura.getIdDetalle();
        this.idEmpleado = Optional.ofNullable(detalleFactura.getIdEmpleado())
                .map(PersonaDTO::toDto)
                .orElse(new PersonaDTO());
        this.idProducto = Optional.ofNullable(detalleFactura.getIdProducto())
                .map(ProductoDTO::toDto)
                .orElse(new ProductoDTO());
        this.idReserva = Optional.ofNullable(detalleFactura.getIdReserva())
                .map(ReservaDTO::toDto)
                .orElse(new ReservaDTO());
    }

    public static DetalleFacturaDTO toDto(DetalleFactura detalleFactura) {
        return new DetalleFacturaDTO(detalleFactura);
    }
}
