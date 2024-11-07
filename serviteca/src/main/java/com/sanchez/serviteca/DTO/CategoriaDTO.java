package com.sanchez.serviteca.DTO;

import com.sanchez.serviteca.Entities.Categoria;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class CategoriaDTO {

    private Boolean estadoCategoria;
    private Integer idCategoria;
    private String nombreCategoria;
    private String descripcion;
    //private List<ProductoDTO> productoList;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.estadoCategoria = categoria.getEstadoCategoria();
        this.idCategoria = categoria.getIdCategoria();
        this.nombreCategoria = categoria.getNombreCategoria();
        this.descripcion = categoria.getDescripcion();

        /*COMO RECORRER UN LISTADO DE OBJETO DTO
        this.productoList = categoria.getProductoList().stream().map(data -> {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setIdProducto(data.getIdProducto());
            productoDTO.setNombreProducto(data.getNombreProducto());
            productoDTO.setDescripcion(data.getDescripcion());
            productoDTO.setDescripcion(data.getDescripcion());

            return productoDTO;
        }).collect(Collectors.toList());*/
    }

    public static CategoriaDTO toDto(Categoria categoria){
        return new CategoriaDTO(categoria);
    }
}
