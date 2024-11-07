package com.sanchez.serviteca.Controllers;

import com.sanchez.serviteca.DTO.ProductoDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("/save")
    ResponseEntity<ResponseDTO> save(@RequestBody ProductoDTO productoDTO) {
        ResponseDTO dto = productoService.save(productoDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/disable")
    ResponseEntity<ResponseDTO> disable(@RequestParam(value = "id") Integer id) {
        ResponseDTO dto = productoService.disable(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/enable")
    ResponseEntity<ResponseDTO> enable(@RequestParam(value = "id") Integer id) {
        ResponseDTO dto = productoService.enable(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/getAll")
    List<ProductoDTO> getAll() {
        return productoService.getAll();
    }
}
