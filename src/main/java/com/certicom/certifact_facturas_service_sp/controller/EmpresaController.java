package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.EmpresaDto;
import com.certicom.certifact_facturas_service_sp.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{ruc}")
    private ResponseEntity<EmpresaDto> obtenerEmpresaPorRuc(@PathVariable String ruc) {
        return new ResponseEntity<>(empresaService.obtenerEmpresaRuc(ruc), HttpStatus.OK);
    }

}
