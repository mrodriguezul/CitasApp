package com.mrodriguezul.citasapp.web.controller;

import com.mrodriguezul.citasapp.domain.Doctor;
import com.mrodriguezul.citasapp.domain.Paciente;
import com.mrodriguezul.citasapp.domain.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Paciente", description = "Operacines relacionadas con pacientes 👴🧓")
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Obtener todos los pacientes", description = "Retorna una lista paginada de todos los pacientes")
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
}
