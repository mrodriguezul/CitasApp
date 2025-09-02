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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Doctor", description = "Operacines relacionadas con doctores 👨‍🔬")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Operation(summary = "Obtener todos los doctores", description = "Retorna una lista de todos los doctores")
    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }

    @Operation(summary = "Buscar doctores por nombre o apellido", description = "Retorna una lista de doctores que coinciden con el nombre o apellido proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctores encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron doctores")
    })
    @Parameters(value = {
            @Parameter(name = "names", description = "Nombres del doctor a buscar", required = false, example = "Juan Carlos"),
            @Parameter(name = "surnames", description = "Apellidos del doctor a buscar", required = false, example = "García López")
    })
    @GetMapping("/search/name")
    public ResponseEntity<List<Doctor>> getDoctorsByNameOrSurname(
            @RequestParam(required = false) String names,
            @RequestParam(required = false) String surnames) {
        List<Doctor> doctors = doctorService.getAllByNameOrSurname(names, surnames);
        if (doctors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctors);
    }

    @Operation(summary = "Buscar doctores por especialidad", description = "Retorna una lista de doctores que pertenecen a una especialidad específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctores encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron doctores para la especialidad")
    })
    @Parameters(value = {
            @Parameter(name = "specialityId", description = "ID de la especialidad a buscar", required = true, example = "1")
    })
    @GetMapping("/specialty/{specialityId}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpeciality(@PathVariable Long specialityId) {
        List<Doctor> doctors = doctorService.getAllBySpeciality(specialityId);
        if (doctors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctors);
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

    @Operation(summary = "Buscar doctor por número de identificación", description = "Retorna un doctor específico por su número de identificación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor encontrado"),
            @ApiResponse(responseCode = "404", description = "Doctor no encontrado")
    })
    @Parameters(value = {
            @Parameter(name = "identificationNumber", description = "Número de identificación del doctor", required = true, example = "12345678")
    })
    @GetMapping("/identification/{identificationNumber}")
    public ResponseEntity<Doctor> getDoctorByIdentificationNumber(@PathVariable String identificationNumber) {
        return doctorService.getAllByIdentificationNumber(identificationNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar doctor por tipo y número de identificación", description = "Retorna un doctor específico por su tipo y número de identificación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor encontrado"),
            @ApiResponse(responseCode = "404", description = "Doctor no encontrado")
    })
    @Parameters(value = {
            @Parameter(name = "identificationId", description = "ID del tipo de identificación", required = true, example = "1"),
            @Parameter(name = "identificationNumber", description = "Número de identificación del doctor", required = true, example = "12345678")
    })
    @GetMapping("/identification/{identificationId}/{identificationNumber}")
    public ResponseEntity<Doctor> getDoctorByIdentificationTypeAndNumber(
            @PathVariable Long identificationId,
            @PathVariable String identificationNumber) {
        return doctorService.getDoctorByIdentificationTypeAndIdentificationNumber(identificationId, identificationNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo doctor", description = "Guarda la información de un nuevo doctor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Doctor creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
        if(doctor.getId() == null || !doctorService.existsById(doctor.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.save(doctor));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Actualiza datos de un doctor", description = "Actualiza la información de un doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PutMapping
    public ResponseEntity<Doctor> update(@RequestBody Doctor doctor) {
        if(doctor.getId() != null && doctorService.existsById(doctor.getId())) {
            return ResponseEntity.ok(doctorService.save(doctor));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Eliminar un doctor por ID", description = "Elimina el doctor especificado por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Doctor eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Doctor no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if(doctorService.existsById(id)){
            doctorService.delete(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
