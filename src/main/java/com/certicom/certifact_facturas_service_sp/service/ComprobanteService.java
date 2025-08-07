package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherFilterDto;
import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherInterDto;
import com.certicom.certifact_facturas_service_sp.entity.ComprobanteEntity;

import java.util.List;

public interface ComprobanteService {

    List<PaymentVoucherInterDto> searchInvoiceByFilter(
            Long idUsuario, String filtroDesde, String filtroHasta,
            String filtroTipoComprobante, String filtroRuc, String filtroSerie, Integer filtroNumero,
            Integer pageNumber, Integer perPage, Integer estadoSunat
    );
    List<ComprobanteEntity> getAllPaymentVouchers();

}
