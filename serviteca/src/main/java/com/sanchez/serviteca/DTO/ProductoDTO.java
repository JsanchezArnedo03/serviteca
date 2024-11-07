package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.Producto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class ProductoDTO implements Serializable {

    private Integer idProducto;
    private String codigoProducto;
    private String nombreProducto;
    private String descripcion;
    private String precio;
    private boolean estado;
    private CategoriaDTO categoria;
    private ProveedorDTO proveedor;

    public ProductoDTO() {
    }

    public ProductoDTO(Producto producto) {
        this.idProducto = producto.getIdProducto();
        this.codigoProducto = producto.getCodigoProducto();
        this.nombreProducto = producto.getNombreProducto();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.estado = producto.getEstado();
        this.categoria = Optional.ofNullable(producto.getCategoria())
                .map(CategoriaDTO::toDto)
                .orElse(new CategoriaDTO());
        this.proveedor = Optional.ofNullable(producto.getProveedor())
                .map(ProveedorDTO::toDto)
                .orElse(new ProveedorDTO());
    }

    public static ProductoDTO toDto(Producto producto) {
        return new ProductoDTO(producto);
    }
}
