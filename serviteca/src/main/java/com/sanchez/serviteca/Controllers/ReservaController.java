package com.sanchez.serviteca.Controllers;

import com.sanchez.serviteca.DTO.ReservaDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @GetMapping("/getAll")
    List<ReservaDTO> getAll() {
        return reservaService.getAll();
    }

    @GetMapping("/findById")
    ReservaDTO findById(@RequestParam(value = "id") Integer id) {
        return reservaService.findById(id);
    }

    @PostMapping("/create")
    ResponseEntity<ResponseDTO> create(@RequestBody ReservaDTO reservaDTO) {
        ResponseDTO dto = reservaService.create(reservaDTO);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/update-status")
    ResponseEntity<ResponseDTO> update_status(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "idStatus") Integer idStatus) {
        ResponseDTO dto = reservaService.updateStatus(id, idStatus);
        return ResponseEntity.ok(dto);
    }
}
