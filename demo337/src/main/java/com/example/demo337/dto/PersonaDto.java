package com.example.demo337.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonaDto {
    private Long id;
    private String Nombre;
    private String Apellido;
    private int edad;
}
