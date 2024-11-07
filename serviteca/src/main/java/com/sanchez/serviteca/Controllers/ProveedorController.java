package com.sanchez.serviteca.Controllers;

import com.sanchez.serviteca.DTO.ProveedorDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    ProveedorService proveedorService;

    @PostMapping("/save")
    ResponseDTO save(@RequestBody ProveedorDTO proveedorDTO) {
        return proveedorService.save(proveedorDTO);
    }

    @GetMapping("/findByName")
    ResponseEntity<ProveedorDTO> findById(@RequestParam(value = "id") Integer id) {
        ProveedorDTO dto = proveedorService.findById(id);
        return ResponseEntity.ok(dto);
    }
    @PutMapping("/delete")
    ResponseEntity<ResponseDTO>delete(@RequestParam(value = "id")Integer id){
        ResponseDTO dto = proveedorService.delete(id);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/getAll")
    List<ProveedorDTO>getAll(){
        return proveedorService.getAll();
    }
}
