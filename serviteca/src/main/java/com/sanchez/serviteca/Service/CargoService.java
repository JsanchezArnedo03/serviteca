package com.sanchez.serviteca.Service;

import com.sanchez.serviteca.DTO.CargoDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CargoService {
    ResponseDTO save(CargoDTO cargoDTO);

    ResponseDTO disable(Integer id);
    ResponseDTO enable(Integer id);

    List<CargoDTO> getAll();

    ResponseEntity<CargoDTO> findById(Integer id);

}
