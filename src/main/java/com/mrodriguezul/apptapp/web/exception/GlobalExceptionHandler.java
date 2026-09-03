package com.mrodriguezul.apptapp.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        logger.error("Error interno del servidor: ", ex);

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Error interno del servidor");
        errorResponse.put("message", "Ha ocurrido un error inesperado. Por favor, inténtelo más tarde.");
        errorResponse.put("status", 500);
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, Object>> handleDataAccessException(DataAccessException ex) {
        logger.error("Error de acceso a datos: ", ex);

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Error de base de datos");
        errorResponse.put("message", "Error al acceder a los datos. Por favor, inténtelo más tarde.");
        errorResponse.put("status", 500);
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        logger.warn("Error de validación: ", ex);

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Datos inválidos");
        errorResponse.put("message", "Los datos proporcionados no son válidos");
        errorResponse.put("status", 400);
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        logger.warn("Error de tipo de parámetro: ", ex);

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Parámetro inválido");
        errorResponse.put("message", "El parámetro proporcionado no tiene el formato correcto");
        errorResponse.put("status", 400);
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        logger.error("Error de tiempo de ejecución: ", ex);

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Error de procesamiento");
        errorResponse.put("message", ex.getMessage() != null ? ex.getMessage() : "Error durante el procesamiento de la solicitud");
        errorResponse.put("status", 500);
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
