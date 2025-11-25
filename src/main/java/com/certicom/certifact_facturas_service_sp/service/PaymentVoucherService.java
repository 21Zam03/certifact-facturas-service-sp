package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.others.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherModel;

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

    List<PaymentVoucherModel> getTotalSoles(
            String rucEmisor, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer idOficina, String estadoSunat, Integer pageNumber, Integer perPage
    );

    PaymentVoucherModel savePaymentVoucher(PaymentVoucherModel paymentVoucherModel);

    PaymentVoucherModel findPaymentVoucherById(Long id);

    Integer findFirst1ByTipoComprobanteAndSerieAndRucEmisorOrderByNumeroDesc(String tipoComprobante, String serie, String ruc);

    PaymentVoucherModel getPaymentVoucherByIdentificadorDocumento(String identificadorDocumento);

    int updateStatePaymentVoucher(Long idPaymentVoucher, String codigo, String messageResponse, String codesResponse);

    int updateStatePaymentVoucher(Long idPaymentVoucher, String codigo, String estadoEnSunat, String messageResponse, String codesResponse);

    int updateStatePaymentVoucher(List<String> identificadorComprobantes, String estadoPendienteAnulacion, String usuario, Timestamp fechaModificacion);

    PaymentVoucherModel findPaymentVoucherByRucAndTipoComprobanteAndSerieAndNumero(
            String rucEmisor, String tipoComprobante, String serie, Integer numero
    );

    PaymentVoucherModel findPaymentVoucherByRucAndTipoComprobanteAndSerieDocumentoAndNumeroDocumento(
            String finalRucEmisor, String tipoComprobante, String serieDocumento, Integer numeroDocumento
    );

    Integer getUltimoNumeroForNumeracion(String tipoDocumento, String serie, String ruc);

    List<PaymentVoucherModel> findAllByTipoComprobanteInAndNumDocIdentReceptorAndRucEmisorAndTipoOperacionAndEstadoOrderByNumDocIdentReceptor(
        List<String> tipoComprobante,
        String numDocIdentReceptor,
        String rucEmisor,
        String tipoOperacion,
        String estado
    );

    List<PaymentVoucherModel> getPaymentVocuherByCredito(String numDocIdentReceptor, String rucEmisor);

    List<PaymentVoucherModel> findByIdPaymentVoucherInterList(List<Long> ids);

    int updateComprobantesByBajaDocumentos(List<String> identificadoresComprobantes, String usuario, Timestamp fechaModificacion);
    int updateComprobantesOnResumenError(List<String> identificadoresComprobantes, String usuario, Timestamp fechaModificacion);

}
