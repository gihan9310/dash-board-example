package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@ControllerAdvice
@RestController
public class CustomResponseExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectObjectException(ItemException exception , WebRequest request){
        ItemExceptionResponse response = new ItemExceptionResponse(exception.getMessage());
        return  new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectObjectException(OrderException exception , WebRequest request){
        OrderExceptionResponse response = new OrderExceptionResponse(exception.getMessage());
        return  new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectObjectException(ItemTypeException exception , WebRequest request){
        ItemTypeExceptionResponse response = new ItemTypeExceptionResponse(exception.getMessage());
        return  new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectObjectException(SupplierException exception , WebRequest request){
        SupplierExceptionResponese response = new SupplierExceptionResponese(exception.getMessage());
        return  new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectObjectException(CommonException exception , WebRequest request){
        CommonExceptionResponse response = new CommonExceptionResponse(exception.getMessage());
        return  new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}
