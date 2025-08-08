package com.mrodriguezul.citasapp.web.controller;

import com.mrodriguezul.citasapp.domain.Identificacion;
import com.mrodriguezul.citasapp.domain.service.IdentificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Identificación", description = "Operaciones relacionadas con identificaciones")
@RestController
@RequestMapping("/identificacion")
public class IdentificacionController {

    @Autowired
    private IdentificacionService identificacionService;

    @Operation(summary = "Listar todas las identificaciones", description = "Obtiene una lista de todas las identificaciones")
    @ApiResponse(responseCode = "200", description = "Listado exitoso")
    @GetMapping("")
    ResponseEntity<List<Identificacion>> listarIdentificaciones(){
        return new ResponseEntity<>(identificacionService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una identificación por ID", description = "Obtiene una identificación específica por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Identificación encontrada"),
        @ApiResponse(responseCode = "404", description = "Identificación no encontrada")
    })
    @Parameters(value = {
            @Parameter(name = "id", description = "ID de la indetificación a buscar", required = true, example = "2")
    })
    @GetMapping("/{idIdentificacion}")
    public ResponseEntity<Identificacion> obtenerIdentificacion(@PathVariable("idIdentificacion") Long idIdentificacion){
        return identificacionService.getIdentificacion(idIdentificacion).map(identificacion -> {
            return new ResponseEntity<>(identificacion, HttpStatus.OK);
        }).orElseGet(() -> {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        });
    }

    @Operation(summary = "Registrar una nueva identificación", description = "Guarda la información de una nueva identificación")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Identificación creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping()
    public ResponseEntity<Identificacion> guardarIdentificacion(@RequestBody Identificacion identificacion){
        return new ResponseEntity<>(identificacionService.save(identificacion), HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar una identificación por ID", description = "Elimina la identificación especificada por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Identificación eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Identificación no encontrada")
    })
    @DeleteMapping("/{idIdentificacion}")
    public ResponseEntity eliminarIdentificacion(@PathVariable("idIdentificacion") Long idIdentificacion){
        if(identificacionService.delete(idIdentificacion)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
