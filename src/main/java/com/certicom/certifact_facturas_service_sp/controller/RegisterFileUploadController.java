package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.RegisterFileUploadDto;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import com.certicom.certifact_facturas_service_sp.service.SubidaRegistroArchivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RegisterFileUploadController.API_PATH)
@RequiredArgsConstructor
public class RegisterFileUploadController {

    public final static String API_PATH = "/api/register-file-upload";

    private final SubidaRegistroArchivoService subidaRegistroArchivoService;

    @PostMapping
    private ResponseEntity<SubidaRegistroArchivoEntity> registrarArchivo(@RequestBody RegisterFileUploadDto registerFileUploadDto) {
        return new ResponseEntity<>(subidaRegistroArchivoService.regitrarSubidaArchivo(registerFileUploadDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<RegisterFileUploadDto> findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc
            (@RequestParam Long idPayment, @RequestParam String tipoArchivo, @RequestParam String estadoArchivo) {
        return new ResponseEntity<>(
                subidaRegistroArchivoService.findFirst1ByPaymentVoucherIdPaymentVoucherAndTipoArchivoAndEstadoArchivoOrderByOrdenDesc(idPayment, tipoArchivo, estadoArchivo),
                HttpStatus.OK
        );
    }



}
