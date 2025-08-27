package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.service.DetailPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DetailPaymentController.API_PATH)
@RequiredArgsConstructor
public class DetailPaymentController {

    public static final String API_PATH = "/api/detail-payment-voucher";
    private final DetailPaymentService detailPaymentService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteDetailPaymentVoucherById(@PathVariable("id") Long detailPaymentVoucherId) {
        return new ResponseEntity<>(detailPaymentService.deleteDetailPaymentVoucherById(detailPaymentVoucherId), HttpStatus.OK);
    }

}
