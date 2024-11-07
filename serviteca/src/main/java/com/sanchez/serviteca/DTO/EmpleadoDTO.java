package com.sanchez.serviteca.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class EmpleadoDTO extends PersonaDTO {
    private float salario;
    private Date fechaIngreso;
    private Date fechaDespido;
    private CargoDTO cargo;
}
