package com.sanchez.serviteca.Service;

import com.sanchez.serviteca.DTO.ProveedorDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Entities.Proveedor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProveedorService {

    ResponseDTO save(ProveedorDTO proveedorDTO);
    ResponseDTO delete(Integer id);
    ProveedorDTO findById(Integer id);
    List<ProveedorDTO>getAll();
}
