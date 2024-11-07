package com.sanchez.serviteca.DTO;


import com.sanchez.serviteca.Entities.Cargo;
import lombok.Data;

import java.util.List;

@Data
public class CargoDTO {

    private boolean estado;
    private Integer idCargo;
    private String cargo;

    public CargoDTO() {
    }

    public CargoDTO(Cargo cargo) {
        this.estado = cargo.getEstado();
        this.idCargo = cargo.getIdCargo();
        this.cargo = cargo.getCargo();
    }

    public static CargoDTO toDto(Cargo cargo) {
        return new CargoDTO(cargo);
    }
}
