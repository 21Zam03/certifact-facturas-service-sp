package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.service.CuotasPaymentVoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CuotaPaymentVoucherController.API_PATH)
@RequiredArgsConstructor
public class CuotaPaymentVoucherController {

    public static final String API_PATH = "/api/payment_cuotas";
    private final CuotasPaymentVoucherService cuotasPaymentVoucherService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deletePaymentCuotasById(@PathVariable("id") Long idCuota) {
        return new ResponseEntity<>(cuotasPaymentVoucherService.deletePaymentCuotasById(idCuota), HttpStatus.OK);
    }

}
