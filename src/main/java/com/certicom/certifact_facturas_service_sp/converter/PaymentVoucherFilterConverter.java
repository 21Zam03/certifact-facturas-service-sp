package com.certicom.certifact_facturas_service_sp.converter;

import com.certicom.certifact_facturas_service_sp.dto.model.PaymentVoucherFilterDto;
import com.certicom.certifact_facturas_service_sp.dto.request.PaymentVoucherFilterRequest;

public class PaymentVoucherFilterConverter {

    public static PaymentVoucherFilterDto toDto(PaymentVoucherFilterRequest paymentVoucherFilterRequest) {
        return PaymentVoucherFilterDto.builder()
                .filtroDesde(paymentVoucherFilterRequest.getFiltroDesde())
                .filtroHasta(paymentVoucherFilterRequest.getFiltroHasta())
                .filtroSerie(paymentVoucherFilterRequest.getFiltroSerie())
                .filtroTipoComprobante(paymentVoucherFilterRequest.getFiltroTipoComprobante())
                .estadoSunat(paymentVoucherFilterRequest.getEstadoSunat())
                .filtroNumero(paymentVoucherFilterRequest.getFiltroNumero())
                .filtroRuc(paymentVoucherFilterRequest.getFiltroRuc())
                .pageNumber(paymentVoucherFilterRequest.getPageNumber())
                .perPage(paymentVoucherFilterRequest.getPerPage())
                .offset(paymentVoucherFilterRequest.getOffset())
                .build();
    }

}
