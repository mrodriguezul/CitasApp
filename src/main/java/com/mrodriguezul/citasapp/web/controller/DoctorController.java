package com.mrodriguezul.citasapp.web.controller;


import com.mrodriguezul.citasapp.domain.Doctor;
import com.mrodriguezul.citasapp.domain.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Doctor", description = "Operacines relacionadas con doctores")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Operation(summary = "Obtener todos los doctores", description = "Retorna una lista de todos los doctores")
    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }

    @Operation(summary = "Obtener un doctor por ID", description = "Retorna un doctor específico por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor encontrado"),
            @ApiResponse(responseCode = "404", description = "Doctor no encontrado")
    })
    @Parameters(value = {
            @Parameter(name = "id", description = "ID del doctor a buscar", required = true, example = "1")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id) {
        return doctorService.getDoctor(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo doctor", description = "Guarda la información de un nuevo doctor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Doctor creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public Doctor save(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    @Operation(summary = "Eliminar un doctor por ID", description = "Elimina el doctor especificado por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Doctor eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Doctor no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if(!doctorService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Test de conexión", description = "Endpoint de prueba para DoctorController")
    @ApiResponse(responseCode = "200", description = "Respuesta exitosa")
    @GetMapping("/test")
    public String test(){
        return "Hello from DoctorController";
    }

}
