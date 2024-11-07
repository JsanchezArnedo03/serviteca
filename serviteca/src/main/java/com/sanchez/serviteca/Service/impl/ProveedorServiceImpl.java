package com.sanchez.serviteca.Service.impl;

import com.sanchez.serviteca.DTO.ProveedorDTO;
import com.sanchez.serviteca.DTO.ResponseDTO;
import com.sanchez.serviteca.DTO.TipoDocumentoDTO;
import com.sanchez.serviteca.Entities.Proveedor;
import com.sanchez.serviteca.Repositories.ProveedorRepository;
import com.sanchez.serviteca.Repositories.TipoDocumentoRepository;
import com.sanchez.serviteca.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    @Autowired
    ProveedorRepository proveedorRepository;
    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;


    @Override
    public ResponseDTO save(ProveedorDTO proveedorDTO) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Proveedor> exist = Optional.ofNullable(proveedorRepository.findByName(proveedorDTO.getNombreProveedor()));
        if (exist.isPresent()) {
            response.setMensaje("Error ya existe este proveedor");
            return response;
        } else {
            Proveedor proveedor = new Proveedor();
            proveedor.setNombreProveedor(proveedorDTO.getNombreProveedor());
            proveedor.setEmail(proveedorDTO.getEmail());
            proveedor.setDireccion(proveedorDTO.getDireccion());
            proveedor.setRazonSocial(proveedorDTO.getRazonSocial());
            proveedor.setTelefono(proveedorDTO.getTelefono());
            proveedor.setEstado(true);
            proveedor.setCodigoContable(proveedorDTO.getCodigoContable());
            proveedor.setTipoDocumento(Optional.ofNullable(proveedorDTO.getTipoDocumento())
                    .map(TipoDocumentoDTO::getIdTipoDocumento)
                    .flatMap(id -> tipoDocumentoRepository.findById(id))
                    .orElse(null));

            response.setMensaje("Proveedor registrado exitosamente");
            proveedorRepository.save(proveedor);
        }
        return response;
    }

    @Override
    public ResponseDTO delete(Integer id) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Proveedor> exist = proveedorRepository.findById(id);
        if (exist.isPresent()) {
            exist.get().setEstado(false);
            proveedorRepository.save(exist.get());
            response.setMensaje("eliminado con exito");
            response.setError(false);
        } else {
            response.setMensaje("no existo este proveedor.");
        }
        return response;
    }

    @Override
    public ProveedorDTO findById(Integer id) {
        return proveedorRepository.findById(id)
                .map(ProveedorDTO::toDto)
                .orElse(new ProveedorDTO());
    }

    @Override
    public List<ProveedorDTO> getAll() {
        List<Proveedor> proveedors = proveedorRepository.findAll();
        return proveedors.stream()
                .map(ProveedorDTO::toDto)
                .collect(Collectors.toList());
    }

}
