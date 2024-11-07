package com.sanchez.serviteca.Service;

import com.sanchez.serviteca.DTO.ClienteDTO;
import com.sanchez.serviteca.DTO.PersonaDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {
    ResponseEntity<PersonaDTO> findById(Integer id);

    ResponseDTO create(PersonaDTO personaDTO);

    ResponseDTO disable(Integer id);
    ResponseDTO enable(Integer id);

    List<PersonaDTO> getAllClient();

    List<PersonaDTO> getAllEmployees();


}
