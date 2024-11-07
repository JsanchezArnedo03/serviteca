package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.EstadosReserva;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class EstadosReservaDTO {

    private Integer idEstadosReserva;
    private String estado;
    private List<ReservaDTO> reservaList;

    public EstadosReservaDTO() {
    }

    public EstadosReservaDTO(EstadosReserva estadosReserva) {
        this.idEstadosReserva = estadosReserva.getIdEstadosReserva();
        this.estado = estadosReserva.getEstado();
    }

    public static EstadosReservaDTO toDto(EstadosReserva estadosReserva) {
        return new EstadosReservaDTO(estadosReserva);
    }
}
