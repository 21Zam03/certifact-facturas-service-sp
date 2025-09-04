package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.others.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.model.PaymentVoucher;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;

import java.sql.Timestamp;
import java.util.List;

public interface PaymentVoucherService {

    List<PaymentVoucherDto> listPaymentVoucherWithFilter(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );

    Integer countPaymentVoucher(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );

    List<PaymentVoucher> getTotalSoles(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );

    PaymentVoucher savePaymentVoucher(PaymentVoucher paymentVoucher);

    PaymentVoucher findPaymentVoucherById(Long id);

    Integer findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(String tipoComprobante, String serie, String ruc);

    PaymentVoucher getPaymentVoucherByIdentificadorDocumento(String identificadorDocumento);

    int updateStatePaymentVoucher(Long idPaymentVoucher, String codigo, String messageResponse, String codesResponse);

    int updateStatePaymentVoucher(Long idPaymentVoucher, String codigo, String estadoEnSunat, String messageResponse, String codesResponse);

    int updateStatePaymentVoucher(List<String> identificadorComprobantes, String estadoPendienteAnulacion, String usuario, Timestamp fechaModificacion);

    PaymentVoucher findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
            String rucEmisor, String tipoComprobante, String serie, Integer numero
    );

    PaymentVoucher findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
            String finalRucEmisor, String tipoComprobante, String serieDocumento, Integer numeroDocumento
    );

}
