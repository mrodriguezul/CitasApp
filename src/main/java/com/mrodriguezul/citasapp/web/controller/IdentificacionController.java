package com.mrodriguezul.citasapp.web.controller;

import com.mrodriguezul.citasapp.domain.model.Identificacion;
import com.mrodriguezul.citasapp.domain.service.IdentificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Tag(name = "Identificación", description = "Operaciones relacionadas con identificaciones")
@RestController
@RequestMapping("/identificacion")
public class IdentificacionController {

    private static final Logger logger = LoggerFactory.getLogger(IdentificacionController.class);
    private final IdentificacionService identificacionService;

    @Autowired
    public IdentificacionController(IdentificacionService identificacionService) {
        this.identificacionService = identificacionService;
    }

    @Operation(summary = "Listar todas las identificaciones", description = "Obtiene una lista de todas las identificaciones")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado exitoso"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("")
    ResponseEntity<List<Identificacion>> listAll(){
        try {
            List<Identificacion> identificaciones = identificacionService.getAll();
            logger.info("Consulta exitosa, se encontraron {} identificaciones", identificaciones.size());
            return new ResponseEntity<>(identificaciones, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al obtener las identificaciones: ", e);
            throw new RuntimeException("Error al obtener la lista de identificaciones", e);
        }
    }

    @Operation(summary = "Obtener una identificación por ID", description = "Obtiene una identificación específica por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Identificación encontrada"),
        @ApiResponse(responseCode = "404", description = "Identificación no encontrada"),
        @ApiResponse(responseCode = "400", description = "ID inválido"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @Parameters(value = {
            @Parameter(name = "idIdentificacion", description = "ID de la identificación a buscar", required = true, example = "2")
    })
    @GetMapping("/{idIdentificacion}")
    public ResponseEntity<Identificacion> getById(@PathVariable("idIdentificacion") Long idIdentificacion){
        try {
            logger.info("Consultando identificación con ID: {}", idIdentificacion);

            if (idIdentificacion == null || idIdentificacion <= 0) {
                logger.warn("ID de identificación inválido: {}", idIdentificacion);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return identificacionService.getIdentificacion(idIdentificacion).map(identificacion -> {
                logger.info("Identificación encontrada con ID: {}", idIdentificacion);
                return new ResponseEntity<>(identificacion, HttpStatus.OK);
            }).orElseGet(() -> {
                logger.warn("Identificación no encontrada con ID: {}", idIdentificacion);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            });
        } catch (Exception e) {
            logger.error("Error al obtener identificación con ID {}: ", idIdentificacion, e);
            throw new RuntimeException("Error al obtener la identificación con ID: " + idIdentificacion, e);
        }
    }

    @Operation(summary = "Registrar una nueva identificación", description = "Guarda la información de una nueva identificación")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Identificación creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos"),
        @ApiResponse(responseCode = "409", description = "Identificación ya existe"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping()
    public ResponseEntity<Identificacion> save(@Valid @RequestBody Identificacion identificacion){
        try {
            if(identificacion.getIdIdentificacion() == null || !identificacionService.existsById(identificacion.getIdIdentificacion())){
                Identificacion identificacionGuardada = identificacionService.save(identificacion);
                logger.info("Identificación guardada exitosamente con ID: {}", identificacionGuardada.getIdIdentificacion());
                return new ResponseEntity<>(identificacionGuardada, HttpStatus.CREATED);
            }else{
                logger.warn("La identificación con ID {} ya existe, no se puede guardar", identificacion.getIdIdentificacion());
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            logger.error("Error al guardar identificación: ", e);
            throw new ValidationException("Validation failed for the provided identification data: " + e.getMessage(), e);
        }
    }

    @Operation(summary = "Actualizar identificación", description = "Actualiza la información de identificación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Identificación actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "404", description = "Identificación no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping()
    public ResponseEntity<Identificacion> update(@Valid @RequestBody Identificacion identificacion){
        try {
            if(identificacion.getIdIdentificacion() != null && identificacionService.existsById(identificacion.getIdIdentificacion())){
                Identificacion identificacionActualizada = identificacionService.save(identificacion);
                logger.info("Identificación actualizada exitosamente con ID: {}", identificacionActualizada.getIdIdentificacion());
                return new ResponseEntity<>(identificacionActualizada, HttpStatus.OK);
            }else{
                logger.warn("La identificación con ID {} No existe, no se puede actualizar", identificacion.getIdIdentificacion());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error al actualizar identificación: ", e);
            throw new ValidationException("Validation failed for the provided identification data: " + e.getMessage(), e);
        }
    }

    @Operation(summary = "Eliminar una identificación por ID", description = "Elimina la identificación especificada por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Identificación eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Identificación no encontrada"),
        @ApiResponse(responseCode = "400", description = "ID inválido"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{idIdentificacion}")
    public ResponseEntity<Void> delete(@PathVariable("idIdentificacion") Long idIdentificacion){
        try {
            logger.info("Eliminando identificación con ID: {}", idIdentificacion);

            if (idIdentificacion == null || idIdentificacion <= 0) {
                logger.warn("ID de identificación inválido para eliminación: {}", idIdentificacion);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if(identificacionService.delete(idIdentificacion)){
                logger.info("Identificación eliminada exitosamente con ID: {}", idIdentificacion);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                logger.warn("No se pudo eliminar, identificación no encontrada con ID: {}", idIdentificacion);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error al eliminar identificación con ID {}: ", idIdentificacion, e);
            throw new RuntimeException("Error al eliminar la identificación con ID: " + idIdentificacion, e);
        }
    }
}
