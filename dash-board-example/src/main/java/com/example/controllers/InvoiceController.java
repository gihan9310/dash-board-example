package com.example.controllers;

import com.example.dtos.OrderDTO;
import com.example.servies.OrderService;
import com.example.utils.BindingErrorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@RestController
@RequestMapping(value = "/invoice")
@CrossOrigin
public class InvoiceController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody OrderDTO dto , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFields(bindingResult.getFieldErrors());
        }
        OrderDTO order = orderService.create(dto);
        return new ResponseEntity(order, HttpStatus.OK);
    }
}
