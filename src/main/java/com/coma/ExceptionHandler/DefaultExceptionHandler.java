package com.coma.ExceptionHandler;

import com.coma.ExceptionHandler.RunTimeException.BusinessApiException;
import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { Exception.class })
  public final ResponseEntity<Object> someThingWentWrong(Exception e) {
   e.printStackTrace();
    ExceptionModel exceptionResponse = new ExceptionModel(
      e.getMessage(),
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST
    );
    return new ResponseEntity<>(
      exceptionResponse,
      new HttpHeaders(),
      HttpStatus.BAD_REQUEST
    );
  }

  @ExceptionHandler(value = { BusinessApiException.class })
  public final ResponseEntity<Object> BusinessException(
    BusinessApiException e
  ) {
    e.printStackTrace();
    ExceptionModel exceptionResponse = new ExceptionModel(
      e.getMessage(),
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST
    );
    return new ResponseEntity<>(
      exceptionResponse,
      new HttpHeaders(),
      HttpStatus.BAD_REQUEST
    );
  }

  @ExceptionHandler(value = { NullPointerException.class })
  public final ResponseEntity<Object> NullException(NullPointerException e) {
    e.printStackTrace();
    ExceptionModel exceptionResponse = new ExceptionModel(
      "Internal Server error. Please check logs",
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST
    );
    return new ResponseEntity<>(
      exceptionResponse,
      new HttpHeaders(),
      HttpStatus.BAD_REQUEST
    );
  }

  @ExceptionHandler(value = { UsernameNotFoundException.class })
  public final ResponseEntity<Object> UserException(
    UsernameNotFoundException e
  ) {
    ExceptionModel exceptionResponse = new ExceptionModel(
      e.getMessage(),
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST
    );
    return new ResponseEntity<>(
      exceptionResponse,
      new HttpHeaders(),
      HttpStatus.FORBIDDEN
    );
  }

  @ExceptionHandler(value = { IllegalStateException.class })
  public final ResponseEntity<Object> IllegalException(
    IllegalStateException e
  ) {
  
    ExceptionModel exceptionResponse = new ExceptionModel(
      e.getMessage(),
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST
    );
    return new ResponseEntity<>(
      exceptionResponse,
      new HttpHeaders(),
      HttpStatus.BAD_REQUEST
    );
  }
}
