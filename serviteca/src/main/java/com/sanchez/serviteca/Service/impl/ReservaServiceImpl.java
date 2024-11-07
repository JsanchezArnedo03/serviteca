package com.sanchez.serviteca.Service.impl;

import com.sanchez.serviteca.DTO.*;
import com.sanchez.serviteca.Entities.EstadosReserva;
import com.sanchez.serviteca.Entities.Producto;
import com.sanchez.serviteca.Entities.Reserva;
import com.sanchez.serviteca.Repositories.EstadosReservaRepository;
import com.sanchez.serviteca.Repositories.PersonaRepository;
import com.sanchez.serviteca.Repositories.ReservaRepository;
import com.sanchez.serviteca.Repositories.ServicioRepository;
import com.sanchez.serviteca.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    ReservaRepository reservaRepository;
    @Autowired
    EstadosReservaRepository estadosReservaRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ServicioRepository servicioRepository;

    @Override
    public List<ReservaDTO> getAll() {
        List<Reserva> reservaList = reservaRepository.findAll();
        return reservaList.stream()
                .map(ReservaDTO::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO create(ReservaDTO reservaDTO) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Reserva> exist = reservaRepository.findById(reservaDTO.getIdReserva());
        if (exist.isPresent()) {
            response.setMensaje("Error. La reservacion ya se encuentra activa");
        } else {
            Reserva reservacion = new Reserva();
            //ASIGNACION DEL ESTADO DE LA RESERVA
            reservacion.setEstadoReservacion(Optional.ofNullable(reservaDTO.getEstadoReservacion())
                    .map(EstadosReservaDTO::getIdEstadosReserva)
                    .flatMap(id -> estadosReservaRepository.findById(id))
                    .orElse(null));

            //ASIGNACION DEL CLIENTE QUE HACE LA RESERVACION
            reservacion.setCliente(Optional.ofNullable(reservaDTO.getCliente())
                    .map(PersonaDTO::getId)
                    .flatMap(id -> personaRepository.findCliente(reservaDTO.getCliente().getId()))
                    .orElse(null));

            //ASIGNACION DEL SERVICIO QUE SE SOLICITA
            reservacion.setServicio(Optional.ofNullable(reservaDTO.getServicio())
                    .map(ServicioDTO::getIdServicios)
                    .flatMap(id -> servicioRepository.findById(id))
                    .orElse(null));

            reservacion.setFechaReservar(reservaDTO.getFechaReservar());

            reservaRepository.save(reservacion);
            response.setError(false);
            response.setMensaje("La reservacion ha sido registrada de manera existosa");
        }
        return response;
    }

    /***
     *
     * @param id
     * @return objeto de tipo reservaDTO que muestra el ultimo registro de la tabla reservacion
     * con un cliente especifico
     */
    @Override
    public ReservaDTO findById(Integer id) {
        Optional<Reserva> found = reservaRepository.findById(id);
        ReservaDTO dto = null;
        if (found.isPresent()) {
            dto = new ReservaDTO();
            dto.setIdReserva(found.get().getIdReserva());
            //ASIGNACION DEL CLIENTE PARA MOSTRARLO
            dto.setCliente(Optional.ofNullable(found.get().getCliente())
                    .map(ClienteDTO::toDto)
                    .orElse(null));

            //ASIGNACION DEL SERVICIO PARA MOSTRARLO
            dto.setServicio(Optional.ofNullable(found.get().getServicio())
                    .map(ServicioDTO::toDto)
                    .orElse(null));

            //ASIGNACION DEL ESTADO EN EL QUE SE ENCUENTRA LA RESERVA
            dto.setEstadoReservacion(Optional.ofNullable(found.get().getEstadoReservacion())
                    .map(EstadosReservaDTO::toDto)
                    .orElse(null));

            dto.setFechaReservar(found.get().getFechaReservar());
        }
        return dto;
    }

    @Override
    public ResponseDTO updateStatus(Integer id, Integer idStatus) {
        var response = ResponseDTO.builder().mensaje("error").error(true).build();
        Optional<Reserva> reserva = reservaRepository.findById(id);
        if (reserva.isPresent()) {
            Optional<EstadosReserva> estadoOptional = estadosReservaRepository.findById(idStatus);
            estadoOptional.ifPresent(estado -> reserva.get().setEstadoReservacion(estado));
            response.setError(false);
            response.setMensaje("estado actualizado con exito");
        }
        return response;
    }
}
