package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.others.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherModel;
import com.certicom.certifact_facturas_service_sp.model.RegisterFileUpload;
import com.certicom.certifact_facturas_service_sp.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(PaymentVoucherController.API_PATH)
@RequiredArgsConstructor
@Slf4j
public class PaymentVoucherController {

    public static final String API_PATH = "/api/payment-voucher";

    private final PaymentVoucherService paymentVoucherService;
    private final SubidaRegistroArchivoService subidaRegistroArchivoService;

    @GetMapping
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
        System.out.println("LISTA PAYMENT_VOUCHER: "+data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/count-total")
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

    @GetMapping("/cash-total")
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
        List<PaymentVoucherModel> data = paymentVoucherService.getTotalSoles(rucEmisor, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc, filtroSerie, filtroNumero,
                idOficina, estadoSunat, pageNumber, perPage);
        System.out.println("DATA:"+ data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("/state-1")
    public ResponseEntity<Integer> updateStatePaymentVoucher(
            @RequestParam Long idPaymentVoucher, @RequestParam String codigo, @RequestParam String messageResponse,
            @RequestParam String codesResponse
    ) {
        return new ResponseEntity<>(paymentVoucherService.updateStatePaymentVoucher(idPaymentVoucher, codigo, messageResponse, codesResponse), HttpStatus.OK);
    }

    @PutMapping("/state-2")
    public ResponseEntity<?> updateStatePaymentVoucher(
            @RequestParam Long idPaymentVoucher, @RequestParam String codigo, @RequestParam String estadoEnSunat,
            @RequestParam String messageResponse, @RequestParam String codesResponse
    ) {
        return new ResponseEntity<>(paymentVoucherService.updateStatePaymentVoucher(idPaymentVoucher, codigo, estadoEnSunat, messageResponse, codesResponse), HttpStatus.OK);
    }

    @PutMapping("/state-3")
    public ResponseEntity<?> updateStatePaymentVoucher(
            @RequestParam List<String> identificadorComprobantes, @RequestParam String estadoPendienteAnulacion,
            @RequestParam String usuario, @RequestParam Timestamp fechaModificacion
    ) {
        return new ResponseEntity<>(paymentVoucherService.updateStatePaymentVoucher(identificadorComprobantes, estadoPendienteAnulacion, usuario, fechaModificacion), HttpStatus.OK);
    }

    @GetMapping("/id-document")
    public ResponseEntity<PaymentVoucherModel> getPaymentVoucherByIdentificadorDocumento(@RequestParam String idDocumento) {
        return new ResponseEntity<>(paymentVoucherService.getPaymentVoucherByIdentificadorDocumento(idDocumento), HttpStatus.OK);
    }

    @GetMapping("/number")
    public ResponseEntity<Integer> obtenerSiguienteNumeracionPorTipoComprobanteYSerieYRucEmisor(
            @RequestParam String tipoComprobante, @RequestParam String serie, @RequestParam String ruc
    ) {
        return new ResponseEntity<>(
                paymentVoucherService.findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(tipoComprobante, serie, ruc),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<PaymentVoucherModel> savePaymentVoucher(@RequestBody PaymentVoucherModel paymentVoucherModel) {
        log.info("COMPROBANTE: {}", paymentVoucherModel);
        return new ResponseEntity<>(paymentVoucherService.savePaymentVoucher(paymentVoucherModel), HttpStatus.CREATED);
    }

    @GetMapping("/parameters")
    public ResponseEntity<PaymentVoucherModel> findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
            @RequestParam String rucEmisor, @RequestParam String tipoComprobante,
            @RequestParam String serie, @RequestParam Integer numero) {
        return new ResponseEntity<>(
                paymentVoucherService.findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
                        rucEmisor, tipoComprobante, serie, numero
                ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentVoucherModel> findPaymentVoucherById(@PathVariable(name = "id") Long idPaymentVoucher) {
        return new ResponseEntity<>(paymentVoucherService.findPaymentVoucherById(idPaymentVoucher), HttpStatus.OK);
    }

    @GetMapping("/parameters-dto")
    public ResponseEntity<PaymentVoucherModel> findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento
            (@RequestParam String finalRucEmisor, @RequestParam String tipoComprobante,
             @RequestParam String serieDocumento, @RequestParam Integer numeroDocumento) {
        return new ResponseEntity<>(
                paymentVoucherService.findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(finalRucEmisor, tipoComprobante, serieDocumento, numeroDocumento),
                HttpStatus.OK
        );
    }

    @GetMapping("/lastnumber")
    public ResponseEntity<Integer> getUltimoNumeroForNumeracion(
            @RequestParam String tipoDocumento, @RequestParam String serie, @RequestParam String ruc
    ) {
        return new ResponseEntity<>(
                paymentVoucherService.getUltimoNumeroForNumeracion(tipoDocumento, serie, ruc), HttpStatus.OK
        );
    }

    @GetMapping("/anticipo")
    public ResponseEntity<List<PaymentVoucherModel>> findAllByTipoComprobanteInAndNumDocIdentReceptorAndRucEmisorAndTipoOperacionAndEstadoOrderByNumDocIdentReceptor(
            @RequestParam List<String> tipoComprobante,
            @RequestParam String numDocIdentReceptor,
            @RequestParam String rucEmisor,
            @RequestParam String tipoOperacion,
            @RequestParam String estado
    ) {
        return new ResponseEntity<>(
            paymentVoucherService.findAllByTipoComprobanteInAndNumDocIdentReceptorAndRucEmisorAndTipoOperacionAndEstadoOrderByNumDocIdentReceptor(
                    tipoComprobante,
                    numDocIdentReceptor,
                    rucEmisor,
                    tipoOperacion,
                    estado), HttpStatus.OK
        );
    }

    @GetMapping("/credito")
    public ResponseEntity<List<PaymentVoucherModel>> getPaymentVocuherByCredito(
            @RequestParam String numDocIdentReceptor,
            @RequestParam String rucEmisor
    ) {
        return new ResponseEntity<>(paymentVoucherService.getPaymentVocuherByCredito(numDocIdentReceptor, rucEmisor), HttpStatus.OK);
    }

    @GetMapping("/statusSunat")
    public ResponseEntity<List<PaymentVoucherModel>> findAllPaymentVoucherForByIds(@RequestParam List<Long> ids) {
        return new ResponseEntity<>(paymentVoucherService.findByIdPaymentVoucherInterList(ids), HttpStatus.OK);
    }

    /*ARCHIVO, FILE */

    @PostMapping("/register-file-upload")
    private ResponseEntity<SubidaRegistroArchivoEntity> registrarArchivo(@RequestBody RegisterFileUpload registerFileUpload) {
        return new ResponseEntity<>(subidaRegistroArchivoService.regitrarSubidaArchivo(registerFileUpload), HttpStatus.CREATED);
    }

}
