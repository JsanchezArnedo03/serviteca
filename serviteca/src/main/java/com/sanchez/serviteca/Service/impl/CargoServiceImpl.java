package com.sanchez.serviteca.Service.impl;

import com.sanchez.serviteca.DTO.CargoDTO;
import com.sanchez.serviteca.DTO.CategoriaDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.Entities.Cargo;
import com.sanchez.serviteca.Entities.Categoria;
import com.sanchez.serviteca.Repositories.CargoRepository;
import com.sanchez.serviteca.Service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    CargoRepository cargoRepository;

    @Override
    public ResponseDTO save(CargoDTO cargoDTO) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Cargo cargo = new Cargo();
        cargo.setEstado(true);
        cargo.setCargo(cargoDTO.getCargo());
        cargoRepository.save(cargo);
        response.setMensaje("Cargo creado con exito");
        response.setError(false);
        return response;
    }

    @Override
    public ResponseDTO disable(Integer id) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Cargo> exist = cargoRepository.findById(id);
        if (exist.isPresent()) {
            exist.get().setEstado(false);
            response.setError(false);
            response.setMensaje("Deshabilitado exitosamente");
            cargoRepository.save(exist.get());
        } else {
            response.setMensaje("no existe dicho cargo");
        }
        return response;
    }

    @Override
    public ResponseDTO enable(Integer id) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Cargo> exist = cargoRepository.findById(id);
        if (exist.isPresent()) {
            exist.get().setEstado(true);
            response.setError(false);
            response.setMensaje("habilitado exitosamente");
            cargoRepository.save(exist.get());
        } else {
            response.setMensaje("no existe dicho cargo");
        }
        return response;
    }

    @Override
    public List<CargoDTO> getAll() {
        List<Cargo> cargoList = cargoRepository.findAll();
        return cargoList.stream()
                .map(CargoDTO::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<CargoDTO> findById(Integer id) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Cargo> cargo = cargoRepository.findById(id);
        CargoDTO cargoDTO = null;
        if (cargo.isPresent()) {
            cargoDTO = new CargoDTO();
            cargoDTO.setCargo(cargo.get().getCargo());
            cargoDTO.setEstado(cargo.get().getEstado());
            cargoDTO.setIdCargo(cargo.get().getIdCargo());
            response.setError(false);
        } else {
            response.setMensaje("No existe dicha categoria");
        }
        return ResponseEntity.ok(cargoDTO);
    }
}
