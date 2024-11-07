package com.sanchez.serviteca.Service.impl;

import com.sanchez.serviteca.DTO.*;
import com.sanchez.serviteca.Entities.Producto;
import com.sanchez.serviteca.Repositories.CategoriaRepository;
import com.sanchez.serviteca.Repositories.ProductoRepository;
import com.sanchez.serviteca.Repositories.ProveedorRepository;
import com.sanchez.serviteca.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public ResponseDTO save(ProductoDTO productoDTO) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Producto> exist = productoRepository.findById(productoDTO.getIdProducto());
        if (exist.isPresent()) {
            response.setMensaje("Ya existe un producto asi");
            return response;
        } else {
            Producto producto = new Producto();
            producto.setCodigoProducto(productoDTO.getCodigoProducto());
            producto.setNombreProducto(productoDTO.getNombreProducto());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setEstado(true);
            //SET PROVEEDOR
            producto.setProveedor(Optional.ofNullable(productoDTO.getProveedor())
                    .map(ProveedorDTO::getIdProveedor)
                    .flatMap(id -> proveedorRepository.findById(id))
                    .orElse(null));
            //SET CATEGORIA A LA QUE PERTENECE EL PRODUCTO
            producto.setCategoria(Optional.ofNullable(productoDTO.getCategoria())
                    .map(CategoriaDTO::getIdCategoria)
                    .flatMap(id -> categoriaRepository.findById(id))
                    .orElse(null));

            productoRepository.save(producto);
            response.setError(false);
            response.setMensaje("Producto registrado con exito!");
            return response;
        }
    }

    @Override
    public ResponseDTO disable(Integer id) {
        var response = ResponseDTO.builder().mensaje("Error").error(true).build();
        Optional<Producto> exist = productoRepository.findById(id);
        if (exist.isPresent()) {
            exist.get().setEstado(false);
            productoRepository.save(exist.get());
            response.setMensaje("Producto deshabilitado existosamente");
        } else {
            response.setMensaje("Producto inexistente");
        }
        return response;
    }

    @Override
    public ResponseDTO enable(Integer id) {
        var response = ResponseDTO.builder().error(true).mensaje("error").build();
        Optional<Producto> exist = productoRepository.findById(id);
        if (exist.isPresent()) {
            exist.get().setEstado(true);
            productoRepository.save(exist.get());
            response.setError(false);
            response.setMensaje("Habilitado exitosamente");
        } else {
            response.setMensaje("No existe el producto");
        }
        return response;
    }

    @Override
    public List<ProductoDTO> getAll() {
        List<Producto> productoList = productoRepository.findAll();
        return productoList.stream()
                .map(ProductoDTO::toDto)
                .collect(Collectors.toList());
    }
}
