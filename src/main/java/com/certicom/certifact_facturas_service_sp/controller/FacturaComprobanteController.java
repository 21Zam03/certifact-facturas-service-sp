package com.certicom.certifact_facturas_service_sp.controller;

import com.certicom.certifact_facturas_service_sp.dto.model.*;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;
import com.certicom.certifact_facturas_service_sp.entity.SubidaRegistroArchivoEntity;
import com.certicom.certifact_facturas_service_sp.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(FacturaComprobanteController.API_PATH)
@RequiredArgsConstructor
@Slf4j
public class FacturaComprobanteController {

    public static final String API_PATH = "/api/invoice-sp";

    private final PaymentVoucherService paymentVoucherService;
    private final EmpresaService empresaService;
    private final OficinaService oficinaService;
    private final SubidaRegistroArchivoService subidaRegistroArchivoService;
    private final UsuarioService usuarioService;

    /*COMPROBANTE, PAYMENT VOUCHER*/

    @GetMapping
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
        List<ComprobanteDto> data = paymentVoucherService.listarComprobantesConFiltro(rucEmisor, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc,
                filtroSerie, filtroNumero, idOficina, estadoSunat, pageNumber, perPage);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/count-total")
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

    @GetMapping("/cash-total")
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
        List<ComprobanteDto> data = paymentVoucherService.obtenerTotalSolesGeneral(rucEmisor, filtroDesde, filtroHasta, filtroTipoComprobante, filtroRuc, filtroSerie, filtroNumero,
                idOficina, estadoSunat, pageNumber, perPage);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentVoucherEntity> registrarComprobante(@RequestBody PaymentVoucherEntity paymentVoucherEntity) {
        log.info("COMPROBANTE: {}", paymentVoucherEntity);
        return new ResponseEntity<>(paymentVoucherService.registrarComprobante(paymentVoucherEntity), HttpStatus.CREATED);
        //return new ResponseEntity<>(new ComprobanteEntity(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentVoucherEntity> findPaymentVoucherById(@PathVariable(name = "id") Long idPaymentVoucher) {
        return new ResponseEntity<>(paymentVoucherService.findPaymentVoucherById(idPaymentVoucher), HttpStatus.OK);
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

    @PostMapping("/file")
    private ResponseEntity<SubidaRegistroArchivoEntity> registrarArchivo(@RequestBody SubidaRegistroArchivoDto subidaRegistroArchivoDto) {
        return new ResponseEntity<>(subidaRegistroArchivoService.regitrarSubidaArchivo(subidaRegistroArchivoDto), HttpStatus.CREATED);
    }

}
