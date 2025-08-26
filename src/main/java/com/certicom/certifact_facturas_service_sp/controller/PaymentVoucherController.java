package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.*;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import com.certicom.certifact_facturas_service_sp.entity.TmpVoucherSendBillEntity;
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
    private final EmpresaService empresaService;
    private final OficinaService oficinaService;
    private final SubidaRegistroArchivoService subidaRegistroArchivoService;
    private final UsuarioService usuarioService;
    private final TmpVoucherSendBillService tmpVoucherSendBillService;

    /*COMPROBANTE, PAYMENT VOUCHER*/

    @GetMapping("/payment-voucher")
    public ResponseEntity<?> listarComprobantesConFiltro(
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
        List<PaymentVoucherDto> data = paymentVoucherService.listarComprobantesConFiltro(rucEmisor, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc,
                filtroSerie, filtroNumero, idOficina, estadoSunat, pageNumber, perPage);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/payment-voucher/count-total")
    public ResponseEntity<?> contarComprobantes(
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
       Integer cantidad = paymentVoucherService.contarComprobantes(rucEmisor, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc, filtroSerie, filtroNumero,
               idOficina, estadoSunat, pageNumber, perPage);
       return new ResponseEntity<>(cantidad, HttpStatus.OK);
    }

    @GetMapping("/payment-voucher/cash-total")
    public ResponseEntity<?> obtenerTotalSolesGeneral(
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
        List<PaymentVoucherDto> data = paymentVoucherService.obtenerTotalSolesGeneral(rucEmisor, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc, filtroSerie, filtroNumero,
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
    public ResponseEntity<PaymentVoucherEntity> getPaymentVoucherByIdentificadorDocumento(@RequestParam String identificadorDocumento) {
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
    public ResponseEntity<PaymentVoucherEntity> savePaymentVoucher(@RequestBody PaymentVoucherEntity paymentVoucherEntity) {
        log.info("COMPROBANTE: {}", paymentVoucherEntity);
        return new ResponseEntity<>(paymentVoucherService.registrarComprobante(paymentVoucherEntity), HttpStatus.CREATED);
        //return new ResponseEntity<>(new ComprobanteEntity(), HttpStatus.CREATED);
    }

    @GetMapping("/payment-voucher/parameters")
    public ResponseEntity<PaymentVoucherEntity> findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
            @RequestParam String rucEmisor, @RequestParam String tipoComprobante,
            @RequestParam String serie, @RequestParam Integer numero) {
        return new ResponseEntity<>(
                paymentVoucherService.findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
                        rucEmisor, tipoComprobante, serie, numero
                ), HttpStatus.OK);
    }

    @GetMapping("/payment-voucher{id}")
    public ResponseEntity<PaymentVoucherEntity> findPaymentVoucherById(@PathVariable(name = "id") Long idPaymentVoucher) {
        return new ResponseEntity<>(paymentVoucherService.findPaymentVoucherById(idPaymentVoucher), HttpStatus.OK);
    }

    @GetMapping("/payment-voucher/parameters-dto")
    public ResponseEntity<PaymentVoucherDto> findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento
            (@RequestParam String finalRucEmisor, @RequestParam String tipoComprobante,
             @RequestParam String serieDocumento, @RequestParam Integer numeroDocumento) {
        return new ResponseEntity<>(
                paymentVoucherService.findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(finalRucEmisor, tipoComprobante, serieDocumento, numeroDocumento),
                HttpStatus.OK
        );
    }

    /*USUARIO, USER*/

    @GetMapping("/user/{idUsuario}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Long idUsuario) {
        //log.info("UserController - obtenerUsuario - [idUsuario={}]", idUsuario);
        UsuarioInterDto usuario = usuarioService.obtenerUsuario(idUsuario);
        //log.info("UserController - obtenerUsuario - [usuario={}]", usuario.toString());
        return  new ResponseEntity<>(usuario, HttpStatus.OK);
    }


    /*EMPRESA, COMPANY*/

    @GetMapping("/company/state")
    private ResponseEntity<String> obtenerEstadoEmpresaPorRuc(@RequestParam String rucEmisor) {
        return new ResponseEntity<>(empresaService.obtenerEstadoEmpresaPorRuc(rucEmisor), HttpStatus.OK);
    }

    @GetMapping("/company/{ruc}")
    private ResponseEntity<EmpresaDto> obtenerEmpresaPorRuc(@PathVariable String ruc) {
        return new ResponseEntity<>(empresaService.obtenerEmpresaRuc(ruc), HttpStatus.OK);
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
    private ResponseEntity<SubidaRegistroArchivoEntity> registrarArchivo(@RequestBody SubidaRegistroArchivoDto subidaRegistroArchivoDto) {
        return new ResponseEntity<>(subidaRegistroArchivoService.regitrarSubidaArchivo(subidaRegistroArchivoDto), HttpStatus.CREATED);
    }

    @GetMapping("/tmpVoucher/{id}")
    private ResponseEntity<TmpVoucherSendBillEntity> findTmpVoucherByIdPaymentVoucher(@PathVariable Long id) {
        return new ResponseEntity<>(tmpVoucherSendBillService.findTmpVoucherByIdPaymentVoucher(id),HttpStatus.OK);
    }

    @PostMapping("/tmpVoucher")
    private ResponseEntity<?> saveTmpVoucher(@RequestBody TmpVoucherSendBillEntity tmpVoucherSendBillEntity) {
        return new ResponseEntity<>(tmpVoucherSendBillService.saveTmpVoucher(tmpVoucherSendBillEntity),HttpStatus.OK);
    }

}
