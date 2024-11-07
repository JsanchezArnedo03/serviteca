package com.sanchez.serviteca.Controllers;

import com.sanchez.serviteca.DTO.CargoDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    CargoService cargoService;

    @PostMapping("/save")
    ResponseEntity<ResponseDTO> save(@RequestBody CargoDTO cargoDTO) {
        ResponseDTO dto = cargoService.save(cargoDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/getAll")
    List<CargoDTO> getAll() {
        return cargoService.getAll();
    }

    @GetMapping("/findById")
    ResponseEntity<CargoDTO> findById(@RequestParam(value = "id") Integer id) {
        return cargoService.findById(id);
    }

    @PutMapping("/disable")
    ResponseEntity<ResponseDTO> disable(@RequestParam(value = "id") Integer id) {
        ResponseDTO dto = cargoService.disable(id);
        return ResponseEntity.ok(dto);
    }
    @PutMapping("/enable")
    ResponseEntity<ResponseDTO> enable(@RequestParam(value = "id") Integer id) {
        ResponseDTO dto = cargoService.enable(id);
        return ResponseEntity.ok(dto);
    }
}
