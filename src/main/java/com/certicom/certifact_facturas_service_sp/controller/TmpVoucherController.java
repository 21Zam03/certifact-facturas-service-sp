package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.entity.TmpVoucherSendBillEntity;
import com.certicom.certifact_facturas_service_sp.service.TmpVoucherSendBillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TmpVoucherController.API_PATH)
@RequiredArgsConstructor
public class TmpVoucherController {

    public static final String API_PATH = "/api/tmp-voucher";
    private final TmpVoucherSendBillService tmpVoucherSendBillService;

    @PutMapping("/status")
    public ResponseEntity<Integer> updateStatusVoucherTmp(@RequestParam Long identificador, @RequestParam String estado) {
        return new ResponseEntity<>(tmpVoucherSendBillService.updateStatusVoucherTmp(identificador, estado), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<TmpVoucherSendBillEntity> findTmpVoucherByIdPaymentVoucher(@PathVariable Long id) {
        return new ResponseEntity<>(tmpVoucherSendBillService.findTmpVoucherByIdPaymentVoucher(id),HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> saveTmpVoucher(@RequestBody TmpVoucherSendBillEntity tmpVoucherSendBillEntity) {
        return new ResponseEntity<>(tmpVoucherSendBillService.saveTmpVoucher(tmpVoucherSendBillEntity),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Integer> deleteTmpVoucherById(@PathVariable Long id) {
        return new ResponseEntity<>(tmpVoucherSendBillService.deleteTmpVoucherById(id),HttpStatus.OK);
    }

}
