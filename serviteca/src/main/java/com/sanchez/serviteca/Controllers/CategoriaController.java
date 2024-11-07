package com.sanchez.serviteca.Controllers;

import com.sanchez.serviteca.DTO.CategoriaDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/findByName")
    ResponseEntity<CategoriaDTO> findByName(@RequestParam(value = "nombre", required = true) String nombre) {
        return categoriaService.findByName(nombre);
    }

    @PostMapping("/save")
    ResponseDTO save(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.save(categoriaDTO);
    }

    @PutMapping("/disable")
    ResponseDTO disable(@RequestParam(value = "nombre") String nombre) {
        return categoriaService.disable(nombre);
    }

    @GetMapping("/getAll")
    List<CategoriaDTO> getAll() {
        return categoriaService.getAll();
    }
}
