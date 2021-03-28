package com.dithec.workshopmongo.resources.exception;


import com.dithec.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static java.time.LocalDate.now;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Não Encontrado", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(standardError);
    }
}
