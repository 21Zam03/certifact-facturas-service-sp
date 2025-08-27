package com.certicom.certifact_facturas_service_sp.controller;


import com.certicom.certifact_facturas_service_sp.service.AditionalFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AditionalFieldController {

    private final static String API_PATH = "/api/aditional-field-payment-voucher";

    private final AditionalFieldService aditionalFieldService;

    @GetMapping
    public ResponseEntity<Integer> findAditionalFieldIdByValorCampo(@RequestParam String nombreCampo) {
        return new ResponseEntity<>(aditionalFieldService.findAditionalFieldIdByValorCampo(nombreCampo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteAditionalFieldPaymentById(@PathVariable("id") Long aditionalPaymentId) {
        return new ResponseEntity<>(aditionalFieldService.deleteAditionalFieldPaymentById(aditionalPaymentId), HttpStatus.OK);
    }

}
