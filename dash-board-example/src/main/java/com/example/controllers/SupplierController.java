package com.example.controllers;

import com.example.dtos.ItemTypeDTO;
import com.example.dtos.SupplierDTO;
import com.example.servies.SupplierService;
import com.example.utils.BindingErrorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@RestController
@RequestMapping(value = "/suppliers")
@CrossOrigin
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody SupplierDTO dto , BindingResult result){
        if(result.hasErrors()){
            return BindingErrorsResponse.errorFields(result.getFieldErrors());
        }
        SupplierDTO supplierDTO =supplierService.create(dto);
        return new ResponseEntity(supplierDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        List<SupplierDTO> supplierDTOS = supplierService.getAllSuppliers();
        return new ResponseEntity(supplierDTOS, HttpStatus.OK);
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody SupplierDTO dto , BindingResult result){
        if(result.hasErrors()){
            return BindingErrorsResponse.errorFields(result.getFieldErrors());
        }
        SupplierDTO supplierDTO =supplierService.update(dto);
        return new ResponseEntity(supplierDTO, HttpStatus.OK);
    }
}
