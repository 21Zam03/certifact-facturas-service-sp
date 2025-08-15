package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.OficinaDto;
import com.certicom.certifact_facturas_service_sp.service.OficinaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data/office")
@RequiredArgsConstructor
@Slf4j
public class OficinaController {

    private final OficinaService oficinaService;

    @GetMapping
    private ResponseEntity<OficinaDto> obtenerOficina(
            @RequestParam Integer empresaId, @RequestParam String serie, @RequestParam String tipoComprobante
    ) {
        return new ResponseEntity<>(oficinaService.obtenerOficinaPorEmpresaIdYSerieYTipoComprobante(empresaId, serie, tipoComprobante), HttpStatus.OK);
    }

}
