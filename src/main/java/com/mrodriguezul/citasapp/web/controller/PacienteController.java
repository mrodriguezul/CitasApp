package com.mrodriguezul.citasapp.web.controller;

import com.mrodriguezul.citasapp.domain.model.Paciente;
import com.mrodriguezul.citasapp.domain.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Paciente", description = "Operacines relacionadas con pacientes 👴🧓")
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Obtener todos los pacientes", description = "Retorna una lista paginada de pacientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pacientes encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron pacientes")
    })
    @Parameters(value = {
            @Parameter(name = "page", description = "Número de página", required = false, example = "0"),
            @Parameter(name = "size", description = "Cantidad de elementos de página", required = false, example = "10")
    })
    @GetMapping
    public Page<Paciente> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return pacienteService.getAll(page, size);
    }

    @Operation(summary = "Obtener pacientes por identificación", description = "Retorna una lista paginada de pacientes filtrados por identificación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pacientes encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron pacientes")
    })
    @Parameters(value = {
            @Parameter(name = "personIdentificationId", description = "ID de la identificación de la persona", required = true, example = "1", in = ParameterIn.PATH),
            @Parameter(name = "page", description = "Número de página", required = false, example = "0"),
            @Parameter(name = "size", description = "Cantidad de elementos de página", required = false, example = "10"),
            @Parameter(name = "sortBy", description = "Campo para ordenar", required = false, example = "id"),
            @Parameter(name = "sortDir", description = "Dirección de ordenamiento (ASC/DESC)", required = false, example = "ASC")
    })
    @GetMapping("/by-identification/{personIdentificationId}")
    public Page<Paciente> getAllByIdentificationId(
            @PathVariable Long personIdentificationId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDir) {
        return pacienteService.getAllByIdentificationId(personIdentificationId, page, size, sortBy, sortDir);
    }

}
