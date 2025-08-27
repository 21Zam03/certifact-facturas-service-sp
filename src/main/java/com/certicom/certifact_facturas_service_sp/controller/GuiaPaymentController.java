package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.service.GuiaPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GuiaPaymentController.API_PATH)
@RequiredArgsConstructor
public class GuiaPaymentController {

    public static final String API_PATH = "/api/guia-payment-voucher";
    private final GuiaPaymentService guiaPaymentService;

    @DeleteMapping("/api/guia-payment-voucher/{id}")
    public ResponseEntity<Integer> deleteGuiaPaymentById(@PathVariable("id") Long guiaPaymentId) {
        return new ResponseEntity<>(guiaPaymentService.deleteGuiaPaymentById(guiaPaymentId), HttpStatus.OK);
    }

}
