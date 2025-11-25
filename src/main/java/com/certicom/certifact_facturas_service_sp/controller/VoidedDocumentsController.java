package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.model.VoidedDocuments;
import com.certicom.certifact_facturas_service_sp.service.VoidedDocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

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
        return new ResponseEntity<>(voidedDocumentsService.save(voidedDocuments), HttpStatus.OK);
    }

    @GetMapping("/ticket")
    public ResponseEntity<?> getTicket(@RequestParam String ticket) {
        return new ResponseEntity<>(voidedDocumentsService.findByTicket(ticket), HttpStatus.OK);
    }

    @GetMapping("/ticket/state")
    public ResponseEntity<String> getStateByTicket(@RequestParam String ticket) {
        return new ResponseEntity<>(voidedDocumentsService.findEstadoByTicket(ticket), HttpStatus.OK);
    }

    @PutMapping("/api/payment-voucher/baja-documentos")
    ResponseEntity<?> updateComprobantesByBajaDocumentos(
            @RequestParam List<String> identificadoresComprobantes,
            @RequestParam String usuario,
            @RequestParam Timestamp fechaModificacion) {
        return new ResponseEntity<>(voidedDocumentsService.updateComprobantesByBajaDocumentos(identificadoresComprobantes, usuario, fechaModificacion), HttpStatus.OK);
    }

    @PutMapping("/api/payment-voucher/resumen-error")
    ResponseEntity<?> updateComprobantesOnResumenError(
            List<String> identificadoresComprobantes,
            String usuario,
            Timestamp fechaModificacion) {
        return new ResponseEntity<>(voidedDocumentsService.updateComprobantesOnResumenError(identificadoresComprobantes, usuario, fechaModificacion), HttpStatus.OK);
    }

}
