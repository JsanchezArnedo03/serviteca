package com.sanchez.serviteca.Service;

import com.sanchez.serviteca.DTO.ProductoDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;

import java.util.List;

public interface ProductoService {
    ResponseDTO save(ProductoDTO productoDTO);
    ResponseDTO disable(Integer id);
    ResponseDTO enable(Integer id);
    List<ProductoDTO>getAll();
}
