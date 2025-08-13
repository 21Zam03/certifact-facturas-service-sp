package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data/company")
@RequiredArgsConstructor
@Slf4j
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping("estado")
    private ResponseEntity<String> obtenerEstadoEmpresaPorRuc(@RequestParam String rucEmisor) {
        return new ResponseEntity<>(empresaService.obtenerEstadoEmpresaPorRuc(rucEmisor), HttpStatus.OK);
    }

}
