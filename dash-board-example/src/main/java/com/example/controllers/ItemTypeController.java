package com.example.controllers;

import com.example.dtos.ItemTypeDTO;
import com.example.servies.ItemTypeService;
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
@RequestMapping(value = "/items-types")
@CrossOrigin
public class ItemTypeController {

    @Autowired
    private ItemTypeService itemTypeService;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody ItemTypeDTO dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFields(bindingResult.getFieldErrors());
        }
        ItemTypeDTO itemTypeDTO = itemTypeService.create(dto);
        return new ResponseEntity(itemTypeDTO, HttpStatus.OK);
    }

    @GetMapping(value = "getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        List<ItemTypeDTO> allItemTypes = itemTypeService.getAllItemTypes();
        return new ResponseEntity(allItemTypes, HttpStatus.OK);
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody ItemTypeDTO dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFields(bindingResult.getFieldErrors());
        }
        ItemTypeDTO itemTypeDTO = itemTypeService.update(dto);
        return new ResponseEntity(itemTypeDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        Long deleteKey= itemTypeService.delete(id);
        return new ResponseEntity(deleteKey, HttpStatus.OK);
    }
}
