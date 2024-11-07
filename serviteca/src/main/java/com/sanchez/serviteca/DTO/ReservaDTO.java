package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.Reserva;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
public class ReservaDTO {

    private Integer idReserva;
    private Date fechaReservar;
    private EstadosReservaDTO estadoReservacion;
    private PersonaDTO cliente;
    private ServicioDTO servicio;

    public ReservaDTO() {
    }

    public ReservaDTO(Reserva reserva) {
        this.idReserva = reserva.getIdReserva();
        this.fechaReservar = reserva.getFechaReservar();
        this.estadoReservacion = Optional.ofNullable(reserva.getEstadoReservacion())
                .map(EstadosReservaDTO::toDto)
                .orElse(new EstadosReservaDTO());
        this.cliente = Optional.ofNullable(reserva.getCliente())
                .map(PersonaDTO::toDto)
                .orElse(new PersonaDTO());
        ;
        this.servicio = Optional.ofNullable(reserva.getServicio())
                .map(ServicioDTO::toDto)
                .orElse(new ServicioDTO());
        ;
    }

    public static ReservaDTO toDto(Reserva reserva) {
        return new ReservaDTO(reserva);
    }
}
