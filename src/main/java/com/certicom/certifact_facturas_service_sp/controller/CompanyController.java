package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.EmpresaDto;
import com.certicom.certifact_facturas_service_sp.dto.model.OseDto;
import com.certicom.certifact_facturas_service_sp.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CompanyController.API_PATH)
@RequiredArgsConstructor
public class CompanyController {

    public final static String API_PATH = "/api/company";
    private final EmpresaService empresaService;

    @GetMapping("/state")
    private ResponseEntity<String> obtenerEstadoEmpresaPorRuc(@RequestParam String rucEmisor) {
        return new ResponseEntity<>(empresaService.obtenerEstadoEmpresaPorRuc(rucEmisor), HttpStatus.OK);
    }

    @GetMapping("/{ruc}")
    private ResponseEntity<EmpresaDto> obtenerEmpresaPorRuc(@PathVariable String ruc) {
        return new ResponseEntity<>(empresaService.obtenerEmpresaRuc(ruc), HttpStatus.OK);
    }

    @GetMapping("/api/company/ose")
    public ResponseEntity<OseDto> findOseByRucInter(@RequestParam String ruc) {
        return new ResponseEntity<>(empresaService.findOseByRucInter(ruc), HttpStatus.OK);
    }


}
