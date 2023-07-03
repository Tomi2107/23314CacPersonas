package com.example.demo337.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPersonaDto {

    private PersonaDto persona;
    private String mensaje;
}
