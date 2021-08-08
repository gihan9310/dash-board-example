package com.example.controllers;

import com.example.dtos.ItemDTO;
import com.example.servies.ItemService;
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
@RequestMapping(value = "/items")
@CrossOrigin
public class ItemServiceController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody ItemDTO dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFields(bindingResult.getFieldErrors());
        }

        ItemDTO item = itemService.save(dto);
        return new ResponseEntity(item, HttpStatus.OK);
    }

    @GetMapping(value = "getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        List<ItemDTO> allItems = itemService.getAllItems();
        return new ResponseEntity(allItems, HttpStatus.OK);
    }

    @PutMapping (value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody ItemDTO dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFields(bindingResult.getFieldErrors());
        }

        ItemDTO item = itemService.update(dto);
        return new ResponseEntity(item, HttpStatus.OK);
    }

    @DeleteMapping (value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        Long nextId = itemService.delete(id);
        return new ResponseEntity(nextId, HttpStatus.OK);
    }

    @GetMapping(value = "getAll/{itemType}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllByType(@PathVariable("itemType")String itemType){
        List<ItemDTO> allItems = itemService.getAllItemsByItemTypes(itemType);
        return new ResponseEntity(allItems, HttpStatus.OK);
    }
}
