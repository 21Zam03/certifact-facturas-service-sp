package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherInterDto;
import com.certicom.certifact_facturas_service_sp.service.ComprobanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data/invoice")
@RequiredArgsConstructor
public class ComprobanteController {

    private final ComprobanteService invoiceService;

    @GetMapping
    public ResponseEntity<?> getInvoices(
            @RequestParam(name = "filtroDesde", required = true) String filtroDesde,
            @RequestParam(name = "filtroHasta", required = true) String filtroHasta,
            @RequestParam(name = "filtroTipoComprobante", required = false) String filtroTipoComprobante,
            @RequestParam(name = "filtroRuc", required = false) String filtroRuc,
            @RequestParam(name = "filtroSerie", required = false) String filtroSerie,
            @RequestParam(name = "filtroNumero", required = false) Integer filtroNumero,
            @RequestParam(name = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(name = "perPage", required = false) Integer perPage,
            @RequestParam(name = "estadoSunat", required = false) Integer estadoSunat,
            @RequestParam(name = "idUsuario", required = true) Long idUsuario
    ) {
        List<PaymentVoucherInterDto> data = invoiceService.searchInvoiceByFilter(idUsuario, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc,
                filtroSerie, filtroNumero, pageNumber, perPage, estadoSunat);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
