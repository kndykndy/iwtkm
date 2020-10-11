package com.somecompany.demorestaurants.exceptions;

import com.somecompany.demorestaurants.exceptions.impl.RestaurantNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler
    extends ResponseEntityExceptionHandler {

  // Generic

  @ExceptionHandler({Exception.class, IllegalStateException.class, IllegalArgumentException.class})
  public final ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request) {
    return new ResponseEntity<>(
        new ExceptionDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Handles javax validation errors.
   */
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    final StringBuilder errorsSb = new StringBuilder();

    for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
      errorsSb.append(error.getDefaultMessage()).append("; ");
    }
    for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
      errorsSb.append(error.getDefaultMessage()).append("; ");
    }

    return new ResponseEntity<>(
        new ExceptionDetails(HttpStatus.BAD_REQUEST, errorsSb.toString()),
        HttpStatus.BAD_REQUEST);
  }

  /**
   * Handles cases when endpoint was not found (i.e. no controller is defined for it).
   */
  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(
      NoHandlerFoundException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    return new ResponseEntity<>(
        new ExceptionDetails(HttpStatus.BAD_REQUEST, ex.getMessage()),
        HttpStatus.BAD_REQUEST);
  }

  /**
   * Handles type mismatch (e.g. text instead of application-json)
   */
  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    return new ResponseEntity<>(
        new ExceptionDetails(
            HttpStatus.BAD_REQUEST,
            "Unsupported media type: " + ex.getContentType()),
        HttpStatus.BAD_REQUEST);
  }

  // Specific

  @ExceptionHandler(RestaurantNotFoundException.class)
  public final ResponseEntity<ExceptionDetails> handleRestaurantNotFoundException(
      RestaurantNotFoundException ex, WebRequest request) {

    return new ResponseEntity<>(
        new ExceptionDetails(HttpStatus.NOT_FOUND, ex.getMessage()),
        HttpStatus.NOT_FOUND);
  }

}
