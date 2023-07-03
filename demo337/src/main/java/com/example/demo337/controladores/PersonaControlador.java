package com.example.demo337.controladores;

import com.example.demo337.dto.PersonaDto;
import com.example.demo337.servicios.IPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaControlador {

    @Autowired
    private IPersonaServicio personaServicio;

    @GetMapping("/personas")
    public ResponseEntity<?> obtenerPersona() {
        return new ResponseEntity<>(personaServicio.listar(), HttpStatus.OK);
    }

    @PostMapping("/personas/nuevo")
    public ResponseEntity<?> guardarPersona(@RequestBody PersonaDto Persona){
        return new ResponseEntity<>(personaServicio.agregar(Persona),HttpStatus.OK);
    }

    @DeleteMapping("/personas/eliminar/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable Long id){
        return new ResponseEntity<>(personaServicio.eliminar(id),HttpStatus.OK);
    }

    @GetMapping("/personas/obtener/{id}")
    public ResponseEntity<?> obtenerPersonaPorId(@PathVariable Long id){
        return new ResponseEntity<>(personaServicio.obtener(id),HttpStatus.OK);
    }
}
