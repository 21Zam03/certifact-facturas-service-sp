package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.model.VoidedDocuments;
import com.certicom.certifact_facturas_service_sp.service.VoidedDocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(VoidedDocumentsController.API_PATH)
@RequiredArgsConstructor
public class VoidedDocumentsController {

    public static final String API_PATH = "/api/voided-documents";
    private final VoidedDocumentsService voidedDocumentsService;

    @GetMapping("/correlativo")
    public ResponseEntity<Integer> getCorrelativoGeneracionByDiaInVoidedDocuments(@RequestParam String ruc, @RequestParam String fechaGeneracionBaja) {
        return new ResponseEntity<>(voidedDocumentsService.getCorrelativoGeneracionByDiaInVoidedDocuments(ruc, fechaGeneracionBaja), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody VoidedDocuments voidedDocuments) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
