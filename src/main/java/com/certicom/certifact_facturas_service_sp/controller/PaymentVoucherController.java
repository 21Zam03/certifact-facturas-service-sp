package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.others.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import com.certicom.certifact_facturas_service_sp.model.OficinaDto;
import com.certicom.certifact_facturas_service_sp.model.PaymentVoucher;
import com.certicom.certifact_facturas_service_sp.model.RegisterFileUploadDto;
import com.certicom.certifact_facturas_service_sp.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PaymentVoucherController.API_PATH)
@RequiredArgsConstructor
@Slf4j
public class PaymentVoucherController {

    public static final String API_PATH = "/api/invoice-sp";

    private final PaymentVoucherService paymentVoucherService;
    private final OficinaService oficinaService;
    private final SubidaRegistroArchivoService subidaRegistroArchivoService;

    @GetMapping("/payment-voucher")
    public ResponseEntity<?> listPaymentVoucherWithFilter(
            @RequestParam(name = "rucEmisor", required = true) String rucEmisor,
            @RequestParam(name = "filtroDesde", required = true) String filtroDesde,
            @RequestParam(name = "filtroHasta", required = true) String filtroHasta,
            @RequestParam(name = "filtroTipoComprobante", required = false) String filtroTipoComprobante,
            @RequestParam(name = "filtroRuc", required = false) String filtroRuc,
            @RequestParam(name = "filtroSerie", required = false) String filtroSerie,
            @RequestParam(name = "filtroNumero", required = false) Integer filtroNumero,
            @RequestParam(name = "idOficina", required = false) Integer idOficina,
            @RequestParam(name = "estadoSunat", required = false) String estadoSunat,
            @RequestParam(name = "pageNumber", required = true) Integer pageNumber,
            @RequestParam(name = "perPage", required = true) Integer perPage
    ) {
        log.info("ComprobanteController - listarComprobantesConFiltro - [rucEmisor={}, filtroDesde={}, filtroHasta={}, filtroTipoComprobante={}, " +
                "filtroRuc={}, filtroSerie={}, filtroNumero={}, idOficina={}, estadoSunat={}, pageNumber={}, perPage={}]", rucEmisor, filtroDesde, filtroHasta,
                filtroTipoComprobante, filtroRuc, filtroSerie, filtroNumero, idOficina, estadoSunat, pageNumber, perPage);
        List<PaymentVoucherDto> data = paymentVoucherService.listPaymentVoucherWithFilter(rucEmisor, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc,
                filtroSerie, filtroNumero, idOficina, estadoSunat, pageNumber, perPage);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/payment-voucher/count-total")
    public ResponseEntity<?> countPaymentVoucher(
            @RequestParam(name = "rucEmisor", required = true) String rucEmisor,
            @RequestParam(name = "filtroDesde", required = true) String filtroDesde,
            @RequestParam(name = "filtroHasta", required = true) String filtroHasta,
            @RequestParam(name = "filtroTipoComprobante", required = false) String filtroTipoComprobante,
            @RequestParam(name = "filtroRuc", required = false) String filtroRuc,
            @RequestParam(name = "filtroSerie", required = false) String filtroSerie,
            @RequestParam(name = "filtroNumero", required = false) Integer filtroNumero,
            @RequestParam(name = "idOficina", required = false) Integer idOficina,
            @RequestParam(name = "estadoSunat", required = false) String estadoSunat,
            @RequestParam(name = "pageNumber", required = true) Integer pageNumber,
            @RequestParam(name = "perPage", required = true) Integer perPage
    ) {
       Integer cantidad = paymentVoucherService.countPaymentVoucher(rucEmisor, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc, filtroSerie, filtroNumero,
               idOficina, estadoSunat, pageNumber, perPage);
       return new ResponseEntity<>(cantidad, HttpStatus.OK);
    }

    @GetMapping("/payment-voucher/cash-total")
    public ResponseEntity<?> getTotalSoles(
            @RequestParam(name = "rucEmisor", required = true) String rucEmisor,
            @RequestParam(name = "filtroDesde", required = true) String filtroDesde,
            @RequestParam(name = "filtroHasta", required = true) String filtroHasta,
            @RequestParam(name = "filtroTipoComprobante", required = false) String filtroTipoComprobante,
            @RequestParam(name = "filtroRuc", required = false) String filtroRuc,
            @RequestParam(name = "filtroSerie", required = false) String filtroSerie,
            @RequestParam(name = "filtroNumero", required = false) Integer filtroNumero,
            @RequestParam(name = "idOficina", required = false) Integer idOficina,
            @RequestParam(name = "estadoSunat", required = false) String estadoSunat,
            @RequestParam(name = "pageNumber", required = true) Integer pageNumber,
            @RequestParam(name = "perPage", required = true) Integer perPage
    ) {
        List<PaymentVoucher> data = paymentVoucherService.getTotalSoles(rucEmisor, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc, filtroSerie, filtroNumero,
                idOficina, estadoSunat, pageNumber, perPage);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("/payment-voucher/state-1")
    public ResponseEntity<Integer> updateStatePaymentVoucher(
            @RequestParam Long idPaymentVoucher, @RequestParam String codigo, @RequestParam String messageResponse,
            @RequestParam String codesResponse
    ) {
        return new ResponseEntity<>(paymentVoucherService.updateStatePaymentVoucher(idPaymentVoucher, codigo, messageResponse, codesResponse), HttpStatus.OK);
    }

    @PutMapping("/payment-voucher/state-2")
    public ResponseEntity<?> updateStatePaymentVoucher(
            @RequestParam Long idPaymentVoucher, @RequestParam String codigo, @RequestParam String estadoEnSunat,
            @RequestParam String messageResponse, @RequestParam String codesResponse
    ) {
        return new ResponseEntity<>(paymentVoucherService.updateStatePaymentVoucher(idPaymentVoucher, codigo, estadoEnSunat, messageResponse, codesResponse), HttpStatus.OK);
    }

    @GetMapping("/payment-voucher/id-document")
    public ResponseEntity<PaymentVoucher> getPaymentVoucherByIdentificadorDocumento(@RequestParam String identificadorDocumento) {
        return new ResponseEntity<>(paymentVoucherService.getPaymentVoucherByIdentificadorDocumento(identificadorDocumento), HttpStatus.OK);
    }

    @GetMapping("/payment-voucher/number")
    public ResponseEntity<Integer> obtenerSiguienteNumeracionPorTipoComprobanteYSerieYRucEmisor(
            @RequestParam String tipoComprobante, @RequestParam String serie, @RequestParam String ruc
    ) {
        return new ResponseEntity<>(
                paymentVoucherService.findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(tipoComprobante, serie, ruc),
                HttpStatus.OK
        );
    }

    @PostMapping("/payment-voucher")
    public ResponseEntity<PaymentVoucher> savePaymentVoucher(@RequestBody PaymentVoucher paymentVoucher) {
        log.info("COMPROBANTE: {}", paymentVoucher);
        return new ResponseEntity<>(paymentVoucherService.savePaymentVoucher(paymentVoucher), HttpStatus.CREATED);
    }

    @GetMapping("/payment-voucher/parameters")
    public ResponseEntity<PaymentVoucher> findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
            @RequestParam String rucEmisor, @RequestParam String tipoComprobante,
            @RequestParam String serie, @RequestParam Integer numero) {
        return new ResponseEntity<>(
                paymentVoucherService.findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
                        rucEmisor, tipoComprobante, serie, numero
                ), HttpStatus.OK);
    }

    @GetMapping("/payment-voucher{id}")
    public ResponseEntity<PaymentVoucher> findPaymentVoucherById(@PathVariable(name = "id") Long idPaymentVoucher) {
        return new ResponseEntity<>(paymentVoucherService.findPaymentVoucherById(idPaymentVoucher), HttpStatus.OK);
    }

    @GetMapping("/payment-voucher/parameters-dto")
    public ResponseEntity<PaymentVoucher> findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento
            (@RequestParam String finalRucEmisor, @RequestParam String tipoComprobante,
             @RequestParam String serieDocumento, @RequestParam Integer numeroDocumento) {
        return new ResponseEntity<>(
                paymentVoucherService.findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(finalRucEmisor, tipoComprobante, serieDocumento, numeroDocumento),
                HttpStatus.OK
        );
    }

    /*OFICINA, OFFICE*/

    @GetMapping("/office")
    private ResponseEntity<OficinaDto> obtenerOficina(
            @RequestParam Integer empresaId, @RequestParam String serie, @RequestParam String tipoComprobante
    ) {
        return new ResponseEntity<>(oficinaService.obtenerOficinaPorEmpresaIdYSerieYTipoComprobante(empresaId, serie, tipoComprobante), HttpStatus.OK);
    }

    /*ARCHIVO, FILE */

    @PostMapping("/register-file-upload")
    private ResponseEntity<SubidaRegistroArchivoEntity> registrarArchivo(@RequestBody RegisterFileUploadDto registerFileUploadDto) {
        return new ResponseEntity<>(subidaRegistroArchivoService.regitrarSubidaArchivo(registerFileUploadDto), HttpStatus.CREATED);
    }

}
