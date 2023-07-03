package com.example.demo337.servicios;

import com.example.demo337.dto.PersonaDto;
import com.example.demo337.dto.RespPersonaDto;
import com.example.demo337.entidades.Persona;
import com.example.demo337.repositorios.IPersonaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServicio implements IPersonaServicio{
        @Autowired
        private IPersonaRepositorio personaRepositorio;

        @Override
        public RespPersonaDto agregar(PersonaDto personaDto) {
            ModelMapper modelMapper = new ModelMapper();
            Persona persona = modelMapper.map(personaDto, Persona.class);
            Persona personaPersistido = personaRepositorio.save(persona);
            RespPersonaDto resp = new RespPersonaDto();
            resp.setPersona(modelMapper.map(personaPersistido, PersonaDto.class));
            resp.setMensaje("Se guardó con éxito...");
            return resp;
        }

        @Override
        public RespPersonaDto eliminar(Long id) {
            RespPersonaDto resp = new RespPersonaDto();
            PersonaDto personaDto = new PersonaDto();
            Optional<Persona> personaOptional = personaRepositorio.findById(id);
            if(personaOptional.isPresent()) {
                ModelMapper mapper = new ModelMapper();
                personaDto = mapper.map(personaOptional.get(), PersonaDto.class);
                personaRepositorio.deleteById(id);
                resp.setMensaje("El Persona ha sido borrado");
            }
            else {
                resp.setMensaje("No existe ese Persona");
                personaDto.setId(id);
            }
            resp.setPersona(personaDto);
            return resp;
        }

        @Override
        public List<PersonaDto> listar() {
            ModelMapper mapper = new ModelMapper();
            List<Persona> personas = personaRepositorio.findAll();
            List<PersonaDto> personasDto = new ArrayList<>();
            personas.stream().forEach(c-> personasDto.add(mapper.map(c, PersonaDto.class)));
            return personasDto;
        }

        @Override
        public RespPersonaDto obtener(Long id) {
            RespPersonaDto resp = new RespPersonaDto();
            PersonaDto personaDto = null;
            Optional<Persona> personaOptional = personaRepositorio.findById(id);
            if(personaOptional.isPresent()) {
                ModelMapper mapper = new ModelMapper();
                personaDto = mapper.map(personaOptional.get(), PersonaDto.class);
                resp.setMensaje("El Persona ha sido obtenido");
            }
            else {
                resp.setMensaje(String.format("El Persona con el id %d no se encuentra", id));
            }
            resp.setPersona(personaDto);
            return resp;
        }
}



