package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherFile;
import com.certicom.certifact_facturas_service_sp.service.PaymentVoucherFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PaymentVoucherFileController.API_PATH)
@RequiredArgsConstructor
public class PaymentVoucherFileController {

    public static final String API_PATH = "/api/payment-voucher-file";

    private final PaymentVoucherFileService paymentVoucherFileService;

    @PostMapping
    private ResponseEntity<Integer> save(@RequestBody PaymentVoucherFile paymentVoucherFile) {
        return new ResponseEntity<>(paymentVoucherFileService.save(paymentVoucherFile), HttpStatus.OK);
    }

}
