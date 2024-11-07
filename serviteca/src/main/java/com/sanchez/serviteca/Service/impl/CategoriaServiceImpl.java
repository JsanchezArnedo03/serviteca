package com.sanchez.serviteca.Service.impl;

import com.sanchez.serviteca.DTO.CategoriaDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Entities.Categoria;
import com.sanchez.serviteca.Repositories.CategoriaRepository;
import com.sanchez.serviteca.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public ResponseEntity<CategoriaDTO> findByName(String filtro) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Categoria categoria = categoriaRepository.findByName(filtro);
        CategoriaDTO categoriaDTO = null;
        if (categoria != null) {
            categoriaDTO = new CategoriaDTO();
            categoriaDTO.setIdCategoria(categoria.getIdCategoria());
            categoriaDTO.setNombreCategoria(categoria.getNombreCategoria());
            categoriaDTO.setEstadoCategoria(categoria.getEstadoCategoria());
            categoriaDTO.setDescripcion(categoria.getDescripcion());
            response.setError(false);
        } else {
            response.setMensaje("No existe dicha categoria");
        }
        return ResponseEntity.ok(categoriaDTO);
    }

    @Override
    public ResponseDTO save(CategoriaDTO categoriaDTO) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();

        Optional<Categoria> exist = Optional.ofNullable(categoriaRepository.findByName(categoriaDTO.getNombreCategoria()));
        if (exist.isPresent() && exist.get().getNombreCategoria() != null) {
            response.setMensaje("Error ya existe dicha categoria");
            return response;
        } else {
            Categoria categoria = new Categoria();
            categoria.setNombreCategoria(categoriaDTO.getNombreCategoria().toUpperCase());
            categoria.setDescripcion(categoriaDTO.getDescripcion());
            categoria.setEstadoCategoria(true);

            categoriaRepository.save(categoria);
            response.setError(false);
            response.setMensaje("Categoria creada con exito");
        }
        return response;
    }

    @Override
    public ResponseDTO disable(String nombre) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Categoria> exist = Optional.ofNullable(categoriaRepository.findByName(nombre.toUpperCase()));
        if (exist.isEmpty()) {
            response.setMensaje("Error. no existe dicha categoria");
            return response;
        } else {
            exist.get().setEstadoCategoria(false);
            response.setMensaje("Deshabilitada con exito");
            categoriaRepository.save(exist.get());
        }
        return response;

    }

    @Override
    public List<CategoriaDTO> getAll() {
        List<Categoria> categoriaList = categoriaRepository.findAll();
        return categoriaList.stream()
                .map(CategoriaDTO::toDto)
                .collect(Collectors.toList());
    }
}
