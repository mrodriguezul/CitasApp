package com.mrodriguezul.citasapp.domain.vo;

import java.util.Objects;

/**
 * Value Object for phone numbers
 */
public class NumeroTelefono {
    private final String valor;

    public NumeroTelefono(String numeroTelefono) {
        if (numeroTelefono == null || numeroTelefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de teléfono no puede estar vacío");
        }
        if (!esValido(numeroTelefono)) {
            throw new IllegalArgumentException("El formato del número de teléfono es inválido: " + numeroTelefono);
        }
        // Normalizar: mantener solo dígitos, espacios y guiones
        this.valor = numeroTelefono.trim().replaceAll("[^0-9\\s\\-\\+]", "");
    }

    private boolean esValido(String numeroTelefono) {
        // Permitir números con dígitos, espacios, guiones y +
        return numeroTelefono.matches("^[\\+]?[0-9\\s\\-]{7,15}$");
    }

    public String getValor() {
        return valor;
    }

    public String getValorSinFormato() {
        return valor.replaceAll("[^0-9\\+]", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumeroTelefono that = (NumeroTelefono) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor;
    }
}