package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherFileModel;
import com.certicom.certifact_facturas_service_sp.service.PaymentVoucherFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PaymentVoucherFileController.API_PATH)
@RequiredArgsConstructor
public class PaymentVoucherFileController {

    public static final String API_PATH = "/api/payment-voucher-file";

    private final PaymentVoucherFileService paymentVoucherFileService;

    @PostMapping
    private ResponseEntity<Integer> save(@RequestBody PaymentVoucherFileModel paymentVoucherFileModel) {
        return new ResponseEntity<>(paymentVoucherFileService.save(paymentVoucherFileModel), HttpStatus.OK);
    }

    @GetMapping("/{id}/idregisterfilesend")
    private ResponseEntity<Long> findActiveXMLIdRegisterFileSendByIdPaymentVoucher(@PathVariable("id") Long idRegisterFileSend) {
        return new ResponseEntity<>(
                paymentVoucherFileService.findActiveXMLIdRegisterFileSendByIdPaymentVoucher(idRegisterFileSend), HttpStatus.OK);
    }

}
