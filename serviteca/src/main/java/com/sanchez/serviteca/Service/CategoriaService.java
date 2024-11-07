package com.sanchez.serviteca.Service;

import com.sanchez.serviteca.DTO.CategoriaDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {

    ResponseEntity<CategoriaDTO>findByName(String filtro);

    ResponseDTO save(CategoriaDTO categoriaDTO);

    ResponseDTO disable(String nombre);
    List<CategoriaDTO>getAll();
}
