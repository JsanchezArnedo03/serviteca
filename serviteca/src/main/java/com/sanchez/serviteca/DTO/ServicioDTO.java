package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.Servicio;
import lombok.Data;

import java.util.List;

@Data
public class ServicioDTO {

    private Integer idServicios;
    private String servicio;
    private String descripcion;

    public ServicioDTO() {
    }

    public ServicioDTO(Servicio servicio) {
        this.idServicios = servicio.getIdServicios();
        this.servicio = servicio.getServicio();
        this.descripcion = servicio.getDescripcion();
    }

    public static ServicioDTO toDto(Servicio servicio) {
        return new ServicioDTO(servicio);
    }
}
