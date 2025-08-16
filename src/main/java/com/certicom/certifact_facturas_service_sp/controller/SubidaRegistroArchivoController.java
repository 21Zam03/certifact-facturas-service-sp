package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.SubidaRegistroArchivoDto;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import com.certicom.certifact_facturas_service_sp.service.SubidaRegistroArchivoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data/file")
@RequiredArgsConstructor
@Slf4j
public class SubidaRegistroArchivoController {

    private final SubidaRegistroArchivoService subidaRegistroArchivoService;

    @PostMapping
    private ResponseEntity<SubidaRegistroArchivoEntity> registrarArchivo(@RequestBody SubidaRegistroArchivoDto subidaRegistroArchivoDto) {
        return new ResponseEntity<>(subidaRegistroArchivoService.regitrarSubidaArchivo(subidaRegistroArchivoDto), HttpStatus.CREATED);
    }

}
