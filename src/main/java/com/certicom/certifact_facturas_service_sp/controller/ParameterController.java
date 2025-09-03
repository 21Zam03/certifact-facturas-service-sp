package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.service.ParameterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ParameterController.API_PATH)
@RequiredArgsConstructor
public class ParameterController {

    public static final String API_PATH = "/api/parameter";
    private final ParameterService parameterService;

    @GetMapping("/name")
    private ResponseEntity<?> findByName(@RequestParam String name) {
        return new ResponseEntity<>(parameterService.findByName(name), HttpStatus.OK);
    }

}
