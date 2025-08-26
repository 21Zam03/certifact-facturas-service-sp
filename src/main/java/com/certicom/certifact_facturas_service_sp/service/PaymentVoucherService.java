package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PaymentVoucherService {

    List<PaymentVoucherDto> listarComprobantesConFiltro(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );

    Integer contarComprobantes(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );

    List<PaymentVoucherDto> obtenerTotalSolesGeneral(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );

    PaymentVoucherEntity registrarComprobante(PaymentVoucherEntity paymentVoucherEntity);

    PaymentVoucherEntity findPaymentVoucherById(Long id);

    Integer findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(String tipoComprobante, String serie, String ruc);

    PaymentVoucherEntity getPaymentVoucherByIdentificadorDocumento(String identificadorDocumento);

    int updateStatePaymentVoucher(Long idPaymentVoucher, String codigo, String messageResponse, String codesResponse);

    int updateStatePaymentVoucher(Long idPaymentVoucher, String codigo, String estadoEnSunat, String messageResponse, String codesResponse);

    PaymentVoucherEntity findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
            String rucEmisor, String tipoComprobante, String serie, Integer numero
    );

    PaymentVoucherDto findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
            String finalRucEmisor, String tipoComprobante, String serieDocumento, Integer numeroDocumento
    );

}
