package com.sanchez.serviteca.Controllers;

import com.sanchez.serviteca.DTO.PersonaDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/findById")
    ResponseEntity<PersonaDTO> findById(@RequestParam(value = "id") Integer id) {
        return personaService.findById(id);
    }

    @GetMapping("/getAllClient")
    List<PersonaDTO> getAllClient() {
        return personaService.getAllClient();
    }

    @GetMapping("/getAllEmployee")
    List<PersonaDTO> getAllEmployee() {
        return personaService.getAllEmployees();
    }

    @PostMapping("/create")
    ResponseEntity<ResponseDTO> create(@RequestBody PersonaDTO personaDTO) {
        ResponseDTO dto = personaService.create(personaDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/disable")
    ResponseEntity<ResponseDTO> disable(@RequestParam(value = "id") Integer id) {
        ResponseDTO dto = personaService.disable(id);
        return ResponseEntity.ok(dto);
    }
    @PutMapping("/enable")
    ResponseEntity<ResponseDTO> enable(@RequestParam(value = "id") Integer id) {
        ResponseDTO dto = personaService.enable(id);
        return ResponseEntity.ok(dto);
    }
}
