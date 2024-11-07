package com.sanchez.serviteca.Service.impl;

import com.sanchez.serviteca.DTO.*;
import com.sanchez.serviteca.Entities.*;
import com.sanchez.serviteca.Repositories.CargoRepository;
import com.sanchez.serviteca.Repositories.PersonaRepository;
import com.sanchez.serviteca.Repositories.TipoDocumentoRepository;
import com.sanchez.serviteca.Repositories.TipoPersonaRepository;
import com.sanchez.serviteca.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    TipoPersonaRepository tipoPersonaRepository;
    @Autowired
    CargoRepository cargoRepository;

    @Override
    public ResponseEntity<PersonaDTO> findById(Integer id) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        PersonaDTO exist = personaRepository.findById(id).map(PersonaDTO::toDto).orElseGet(() -> {
            response.setMensaje("La persona no fue encontrada");
            new PersonaDTO();
            return null;
        });
        return ResponseEntity.ok(exist);
    }

    @Override
    public ResponseDTO create(PersonaDTO personaDTO) {
        var response = ResponseDTO.builder().mensaje("error").error(true).build();
        Persona persona = new Persona();
        Persona exist = personaRepository.findByDocumento(personaDTO.getNumeroDocumento());
        if (exist != null) {
            response.setMensaje("Ya existe esta persona");
        } else {
            if (personaDTO.getTipoPersona() == null && personaDTO.getTipoDocumento() == null) {
                response.setMensaje("informacion importante no puede estar vacia");
            } else {
                Optional<TipoPersona> tipoPersona = tipoPersonaRepository.findById(personaDTO.getTipoPersona().getIdTipoPersona());
                Optional<TipoDocumento> tipoDocumentoDTO = tipoDocumentoRepository.findById(personaDTO.getTipoDocumento().getIdTipoDocumento());

                persona.setTipoDocumento(tipoDocumentoDTO.get());
                persona.setNumeroDocumento(personaDTO.getNumeroDocumento());
                persona.setPrimerNombre(personaDTO.getPrimerNombre());
                persona.setSegundoNombre(personaDTO.getSegundoNombre());
                persona.setPrimerApellido(personaDTO.getPrimerApellido());
                persona.setSegundoApellido(personaDTO.getSegundoApellido());
                persona.setEmail(personaDTO.getEmail());
                persona.setTelefono1(personaDTO.getTelefono1());
                persona.setTelefono2(persona.getTelefono2());
                persona.setEstado(true);
                persona.setFechaIngreso(new Date());
                if (tipoPersona.get().getTipoPersona().equalsIgnoreCase("empleado")) {
                    Optional<Cargo> cargo = cargoRepository.findById(personaDTO.getCargo().getIdCargo());
                    persona.setTipoPersona(tipoPersona.get());
                    persona.setCargo(cargo.get());
                    persona.setFechaIngreso(new Date());
                }
                persona.setTipoPersona(tipoPersona.get());
                personaRepository.save(persona);
                response.setError(false);
                response.setMensaje("Registro exitoso");
            }
        }
        return response;
    }

    @Override
    public ResponseDTO disable(Integer id) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Persona> exist = Optional.ofNullable(personaRepository.empladoDisable(id, "empleado"));
        exist.map(empleado -> {
                    empleado.setEstado(false);
                    personaRepository.save(empleado);
                    response.setMensaje("Deshabilitado exitosamente");
                    response.setError(false);
                    return empleado;
                })
                .orElseGet(() -> {
                    response.setMensaje("no existe dicho empleado");
                    return null; // O cualquier otro valor predeterminado
                });
        return response;
    }

    @Override
    public ResponseDTO enable(Integer id) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Persona> exist = Optional.ofNullable(personaRepository.empladoDisable(id, "empleado"));
        exist.map(empleado -> {
                    empleado.setEstado(true);
                    personaRepository.save(empleado);
                    response.setMensaje("Habilitado exitosamente");
                    response.setError(false);
                    return empleado;
                })
                .orElseGet(() -> {
                    response.setMensaje("no existe dicho empleado");
                    return null; // O cualquier otro valor predeterminado
                });
        return response;
    }

    @Override
    public List<PersonaDTO> getAllClient() {
        List<Persona> personas = personaRepository.getALlClient();
        return personas.stream()
                .map(PersonaDTO::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonaDTO> getAllEmployees() {
        List<Persona> personas = personaRepository.getALlEmployees();
        return personas.stream()
                .map(PersonaDTO::toDto)
                .collect(Collectors.toList());
    }
}
