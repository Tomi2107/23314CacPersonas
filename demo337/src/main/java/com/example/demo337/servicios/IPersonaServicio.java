package com.example.demo337.servicios;

import java.util.List;
import com.example.demo337.dto.PersonaDto;
import com.example.demo337.dto.RespPersonaDto;


public interface IPersonaServicio {
        public RespPersonaDto agregar(PersonaDto personaDto);
        public RespPersonaDto eliminar(Long id);
        public List<PersonaDto> listar();
        public RespPersonaDto obtener(Long id);
    }