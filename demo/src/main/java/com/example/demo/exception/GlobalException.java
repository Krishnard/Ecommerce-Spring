package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(ProductNotFoundException.class)
    /*
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    // let's update this with error response - - customised response having status , message & time stamp.
     */
    
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException ex){
        
        ErrorResponse er = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
        
    }
    
    
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCategoryException(CategoryNotFoundException exception){
        ErrorResponse err = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
    
    
    
    // There can be generic Exception Handlers also
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exe){
        
        ErrorResponse eerr = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Un-expected error occurred. We are working on it",
                LocalDateTime.now()
        );
        
        return new ResponseEntity<>(eerr, HttpStatus.INTERNAL_SERVER_ERROR);
    }
   
}
