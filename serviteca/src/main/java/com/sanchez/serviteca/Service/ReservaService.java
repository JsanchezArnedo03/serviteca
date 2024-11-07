package com.sanchez.serviteca.Service;

import com.sanchez.serviteca.DTO.ReservaDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservaService {
    List<ReservaDTO> getAll();

    ResponseDTO create(ReservaDTO reservaDTO);

    ReservaDTO findById(Integer id);

    ResponseDTO updateStatus(Integer id, Integer idStatus);
}
