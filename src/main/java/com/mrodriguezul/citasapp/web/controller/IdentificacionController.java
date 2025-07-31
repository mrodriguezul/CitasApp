package com.mrodriguezul.citasapp.web.controller;

import com.mrodriguezul.citasapp.domain.Identificacion;
import com.mrodriguezul.citasapp.domain.service.IdentificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/identificaciones")
public class IdentificacionController {

    @Autowired
    private IdentificacionService identificacionService;

    @GetMapping("")
    List<Identificacion> listarIdentificaciones(){
        return identificacionService.findAll();
    }

    @GetMapping("/{idIdentificacion}")
    public Optional<Identificacion> obtenerIdentificacion(@PathVariable("idIdentificacion") Long idIdentificacion){
        return identificacionService.findById(idIdentificacion);
    }

    @PostMapping()
    public Identificacion guardarIdentificacion(@RequestBody Identificacion identificacion){
        return identificacionService.save(identificacion);
    }

    @DeleteMapping("/{idIdentificacion}")
    public boolean eliminarIdentificacion(@PathVariable("idIdentificacion") Long idIdentificacion){
        return identificacionService.delete(idIdentificacion);
    }

}
