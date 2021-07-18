package com.coma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {

    

    @ExceptionHandler(value = { Exception.class })    
        public ResponseEntity<Object> handleInvalidInputException(Exception ex)
         {
          
       return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
   }
    
    
    
}
