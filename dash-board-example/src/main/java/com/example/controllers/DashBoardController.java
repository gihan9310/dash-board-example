package com.example.controllers;

import com.example.dtos.dash_bord.ChartDTO;
import com.example.dtos.dash_bord.DashBordCountDTO;
import com.example.servies.DashBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@RestController
@RequestMapping(value = "/dash-board")
@CrossOrigin
@Slf4j
public class DashBoardController {

    @Autowired
    private DashBoardService dashBoardService;

    @GetMapping(value = "/get-counts",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(){
        log.info("-->>>");
        DashBordCountDTO counts =dashBoardService.getCount();
        return new ResponseEntity(counts, HttpStatus.OK);
    }

    @GetMapping(value = "/get-Item-type-sale",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> barchartInformation(){
        log.info("-->>>");
        ChartDTO dto = dashBoardService.getAllItemTypes();
        return new ResponseEntity(dto, HttpStatus.OK);
    }

}
