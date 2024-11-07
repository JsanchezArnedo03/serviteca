package com.sanchez.serviteca.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {
    private String mensaje;
    private boolean error;
}
