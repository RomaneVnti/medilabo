package com.medilabo.patient.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Gestionnaire global d'exceptions pour l'application.
 * Intercepte les exceptions liées aux validations des données et retourne des réponses HTTP appropriées.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Gère les erreurs de validation des objets envoyés dans le corps de la requête (ex: via @RequestBody).
     *
     * @param ex l'exception déclenchée lors de la validation des arguments de méthode
     * @return une réponse contenant les champs invalides et leurs messages d'erreur, avec un code 400 (BAD_REQUEST)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Gère les erreurs de validation des paramètres de requête (ex: via @RequestParam ou @PathVariable).
     *
     * @param ex l'exception déclenchée lors de la violation de contraintes de validation
     * @return une réponse contenant les champs invalides et leurs messages d'erreur, avec un code 400 (BAD_REQUEST)
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(cv -> {
            String field = cv.getPropertyPath().toString();
            String message = cv.getMessage();
            errors.put(field, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
