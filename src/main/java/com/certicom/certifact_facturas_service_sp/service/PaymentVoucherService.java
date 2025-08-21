package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherDto;
import com.certicom.certifact_facturas_service_sp.entity.PaymentVoucherEntity;

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

}
