package com.mrodriguezul.citasapp.domain.vo;

import java.util.Objects;

/**
 * Value Object for email addresses
 */
public class Email {
    private final String valor;

    public Email(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!esValido(email)) {
            throw new IllegalArgumentException("El formato del email es inválido: " + email);
        }
        this.valor = email.trim().toLowerCase();
    }

    private boolean esValido(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(valor, email.valor);
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