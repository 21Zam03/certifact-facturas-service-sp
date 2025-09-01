package com.certicom.certifact_facturas_service_sp.controller;


import com.certicom.certifact_facturas_service_sp.service.AditionalFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AditionalFieldController.API_PATH)
@RequiredArgsConstructor
public class AditionalFieldController {

    public final static String API_PATH = "/api/aditional-field-payment-voucher";

    private final AditionalFieldService aditionalFieldService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteAditionalFieldPaymentById(@PathVariable("id") Long aditionalPaymentId) {
        return new ResponseEntity<>(aditionalFieldService.deleteAditionalFieldPaymentById(aditionalPaymentId), HttpStatus.OK);
    }

}
