package com.mrodriguezul.citasapp.web.controller;

import com.mrodriguezul.citasapp.domain.Identificacion;
import com.mrodriguezul.citasapp.domain.service.IdentificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/identificacion")
public class IdentificacionController {

    @Autowired
    private IdentificacionService identificacionService;

    @GetMapping("")
    ResponseEntity<List<Identificacion>> listarIdentificaciones(){
        return new ResponseEntity<>(identificacionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idIdentificacion}")
    public ResponseEntity<Identificacion> obtenerIdentificacion(@PathVariable("idIdentificacion") Long idIdentificacion){
        return identificacionService.getIdentificacion(idIdentificacion).map(identificacion -> {
            return new ResponseEntity<>(identificacion, HttpStatus.OK);
        }).orElseGet(() -> {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        });
    }

    @PostMapping()
    public ResponseEntity<Identificacion> guardarIdentificacion(@RequestBody Identificacion identificacion){
        return new ResponseEntity<>(identificacionService.save(identificacion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idIdentificacion}")
    public ResponseEntity eliminarIdentificacion(@PathVariable("idIdentificacion") Long idIdentificacion){
        if(identificacionService.delete(idIdentificacion)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
